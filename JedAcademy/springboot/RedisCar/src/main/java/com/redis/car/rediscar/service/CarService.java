package com.redis.car.rediscar.service;

import com.redis.car.rediscar.dao.repository.CarRepository;
import com.redis.car.rediscar.dto.CarRequestDto;
import com.redis.car.rediscar.dto.CarResponseDto;
import com.redis.car.rediscar.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public void addCar(CarRequestDto requestDto) {
    carRepository.save(carMapper.requestDtoToEntity(requestDto));
  }

  public List<CarResponseDto> getCars() {
    return carMapper.entityToResponseDto(carRepository.findAll());
  }
}
