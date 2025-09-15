package com.post.crud.service;

import com.post.crud.dao.entity.CarEntity;
import com.post.crud.dao.repository.CarRepository;
import com.post.crud.dto.CarResponseDto;
import com.post.crud.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public Long addCar(CarResponseDto carResponseDto) {
    CarEntity carEntity = carMapper.carDtoToEntity(carResponseDto);
    CarEntity save = carRepository.save(carEntity);
    return save.getId();
 }

 public List<CarResponseDto> getAllCars() {
   List<CarEntity> entities = carRepository.findAll();
   return carMapper.carListEntityToDto(entities);
 }

  public CarResponseDto getCars(Long id) {

    var cars = carRepository.findCars(id).orElse(new CarEntity());

    return carMapper.carEntityToDto(cars);
  }

  public void deleteCar(Long id) {
    carRepository.deleteCar(id);
  }

  public void updateCarMark(String mark, String model, Long id) {
    carRepository.updateCarMark(mark,model, id);
  }

}
