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
    var response = new CarEntity(carResponseDto.getMark(), carResponseDto.getModel(), carResponseDto.getYear(), carResponseDto.getEngine(), carResponseDto.getColor(), carResponseDto.getFuelType());
    CarEntity carAdd = carRepository.save(response);
    return carAdd.getId();
  }


}
