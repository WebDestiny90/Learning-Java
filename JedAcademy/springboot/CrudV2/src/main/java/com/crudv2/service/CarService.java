package com.crudv2.service;

import com.crudv2.dao.entity.CarEntity;
import com.crudv2.dao.repository.CarRepository;
import com.crudv2.dto.CarResponseDto;
import com.crudv2.dto.CarRequestDto;
import com.crudv2.dto.DeleteResponseDto;
import com.crudv2.exception.CarNotFoundException;
import com.crudv2.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public Long addCar(CarRequestDto requestDto) {
    return carRepository.save(carMapper.requestDtoToEntity(requestDto)).getId();
  }

  public List<Long> addCars(List<CarRequestDto> requestDtoList) {
    var save = carRepository.saveAll(carMapper.requestDtoListToEntityList(requestDtoList));
    return save.stream().map(CarEntity::getId).toList();
  }

  public CarResponseDto getCarById(Long id) {
    return carMapper.responseEntityToDto(carRepository.findById(id)
            .orElseThrow(()->new CarNotFoundException("car not found with id:" + id)));
  }

  public List<CarResponseDto> getCars() {
    return carRepository.findAll().stream().map(carMapper::responseEntityToDto).toList();
  }

  public CarResponseDto updateCar(CarRequestDto requestDto, Long id) {
    var car = carRepository.findById(id).orElseThrow(()->new CarNotFoundException("car not found with id: " + id));
    car.setModel(requestDto.getModel());
    car.setBrand(requestDto.getBrand());
    car.setYear(requestDto.getYear());
    car.setPrice(requestDto.getPrice());
    car.setEngine(requestDto.getEngine());
    car.setColor(requestDto.getColor());
    car.setFuelType(requestDto.getFuelType());
    var save = carRepository.save(car);
    return carMapper.responseEntityToDto(save);
  }

  public DeleteResponseDto deleteCar(Long id) {
    var car =  carRepository.findByIdAndDeletedAtIsNull(id)
            .orElseThrow(()-> new RuntimeException("car not foud with id: " + id));
    carRepository.deleteById(id);
    car.setDeletedAt(LocalDateTime.now());
    return DeleteResponseDto.builder()
            .message("Car deleted successfully")
            .responseDto(carMapper.responseEntityToDto(car))
            .build();
  }
}