package com.manual.mapping.mapping.Service;

import com.manual.mapping.mapping.dao.entity.CarEntity;
import com.manual.mapping.mapping.dao.repository.CarRepository;
import com.manual.mapping.mapping.dto.CarRequestDto;
import com.manual.mapping.mapping.dto.CarResponseDto;
import com.manual.mapping.mapping.exception.CarNotFoundException;
import com.manual.mapping.mapping.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public Long addCar(CarRequestDto requestDto) {
    var car = carRepository.save(carMapper.requestDtoToEntity(requestDto));
    return car.getId();
  }

  public List<Long> addCarList(List<CarRequestDto> requestDtoList) {
    var cars = carRepository.saveAll(carMapper.requestDtoListToEntityList(requestDtoList));
    return cars.stream().map(CarEntity::getId).toList();
  }

  public CarResponseDto updateCar(CarRequestDto updateRequestDto, Long id) {
    var carEntity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id:" + id));
    carEntity.setBrand(updateRequestDto.getBrand());
    carEntity.setModel(updateRequestDto.getModel());
    carEntity.setYear(updateRequestDto.getYear());
    carEntity.setFuelType(updateRequestDto.getFuelType());
    carEntity.setTransmission(updateRequestDto.getTransmission());
    carEntity.setType(updateRequestDto.getType());
    carEntity.setPrice(updateRequestDto.getPrice());
    carEntity.setMileage(updateRequestDto.getMileage());
    carEntity.setColor(updateRequestDto.getColor());
    carEntity.setAvailable(updateRequestDto.getAvailable());
    carEntity.setDescription(updateRequestDto.getDescription());
    var carSave = carRepository.save(carEntity);
    return carMapper.entityToDto(carSave);
  }

  public void deleteCar(Long id) {
    if (!carRepository.existsById(id)) {
      throw new CarNotFoundException("Car not found with id: " + id);
    }
    carRepository.deleteById(id);
  }

  public CarResponseDto getCarById(Long id) {
    return carMapper.entityToDto(carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id:" + id)));
  }

  public List<CarResponseDto> getCars() {
    return carMapper.responseDtoListToEntity(carRepository.findAll());
  }


}