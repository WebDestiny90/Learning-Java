package com.redis.car.rediscar.service;

import com.redis.car.rediscar.dao.repository.CarRepository;
import com.redis.car.rediscar.dto.CarRequestDto;
import com.redis.car.rediscar.dto.CarResponseDto;
import com.redis.car.rediscar.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
  private static final String CARS_PREFIX = "car: ";
  private final CarRepository carRepository;
  private final CarMapper carMapper;
  private final RedisService redisService;

  public void addCar(CarRequestDto requestDto) {
    var savedEntity = carRepository.save(carMapper.requestDtoToEntity(requestDto));
    CarResponseDto responseDto = carMapper.entityToResponseDto(savedEntity);
    redisService.setValue(CARS_PREFIX + savedEntity.getId(), responseDto);
  }

  public CarResponseDto getCars(Long id) {
    var redisData = redisService.getValue(CARS_PREFIX + id);
    if (redisData != null) {
      log.info("Data loaded from Redis for key: {}", id);
      return (CarResponseDto) redisData;
    }

    log.info("Loading Car from Repository (Cache Miss) for ID: {}", id);
    var entity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with ID: " + id));

    CarResponseDto responseDto = carMapper.entityToResponseDto(entity);

    redisService.setValue(CARS_PREFIX + id, responseDto);

    return responseDto;
  }
}