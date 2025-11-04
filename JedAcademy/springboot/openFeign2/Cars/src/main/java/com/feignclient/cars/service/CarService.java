package com.feignclient.cars.service;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dao.repository.CarRepository;
import com.feignclient.cars.dto.CarRequestDto;
import com.feignclient.cars.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public Long addCar(CarRequestDto requestDto) {
    return carRepository.save(carMapper.dtoToEntity(requestDto)).getId();
  }

  public List<Long> addCars(List<CarRequestDto> requestDtoList) {
    return carRepository.saveAll(carMapper.dtoListToEntityList(requestDtoList))
            .stream().map(CarEntity::getId).toList();
  }
}
