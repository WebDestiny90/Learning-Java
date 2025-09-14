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

  public void addCar(CarResponseDto carResponseDto) {
    carRepository.insertCarReturnId(
            carResponseDto.getMark(),
            carResponseDto.getModel(),
            carResponseDto.getYear(),
            carResponseDto.getEngine(),
            carResponseDto.getColor().name(),
            carResponseDto.getFuelType().name()
    );
 }

  public List<CarResponseDto> getCars() {
    return carMapper.carListEntityToDto(carRepository.findCars());
  }

}
