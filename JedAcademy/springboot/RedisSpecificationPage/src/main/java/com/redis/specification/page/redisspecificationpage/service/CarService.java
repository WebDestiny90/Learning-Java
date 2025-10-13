package com.redis.specification.page.redisspecificationpage.service;

import com.redis.specification.page.redisspecificationpage.dao.entity.CarEntity;
import com.redis.specification.page.redisspecificationpage.dao.repository.CarRepository;
import com.redis.specification.page.redisspecificationpage.dto.CarRequestDto;
import com.redis.specification.page.redisspecificationpage.dto.CarResponseDto;
import com.redis.specification.page.redisspecificationpage.dto.PageResponse;
import com.redis.specification.page.redisspecificationpage.mapper.CarMapper;
import com.redis.specification.page.redisspecificationpage.service.rabbit.MessageProducer;
import com.redis.specification.page.redisspecificationpage.util.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
  private final static String CAR_PREFIX = "CAR:";
  private final CarRepository carRepository;
  private final CarMapper carMapper;
  private final RedisService redisService;
  private final MessageProducer messageProducer;

  public void addCar(CarRequestDto requestDto) {
    messageProducer.sendMessage(requestDto);

//    var cars = carRepository.save(carMapper.requestDtoToEntity(requestDto));
//    return cars.getId();
  }

  public List<Long> addCars(List<CarRequestDto> requestDtoList) {
    var carList = carRepository.saveAll(carMapper.requestListToEntityList(requestDtoList));
    return carList.stream().map(CarEntity::getId).toList();
  }

  public CarResponseDto getCar(Long id) {
    long start = LogUtils.start();
    String key = CAR_PREFIX + id;
    var redisData = redisService.getValue(key);
    if (redisData != null) {
      LogUtils.logDuration("Data loaded from redis", start);
      return (CarResponseDto) redisData;
    }
    log.info("Data loaded from Repository");
    var cars = carRepository.findById(id).orElseThrow(()-> new RuntimeException("Car not found with id:" + id));
    CarResponseDto responseDto = carMapper.responseEntityToDto(cars);
    redisService.setValueS(key, responseDto, 600);
    return responseDto;
  }

  public PageResponse<CarResponseDto> getCars(Integer page, Integer size) {
    long start = LogUtils.start();

    String key = CAR_PREFIX + ":PAGE:" + page + ":SIZE:" + size;

    var redisData = redisService.getValue(key);

    if (redisData != null) {
      LogUtils.logDuration("Data loaded from Redis", start);
      return (PageResponse<CarResponseDto>) redisData;
    }

    Page<CarResponseDto> pageData = carRepository
            .findAll(PageRequest.of(page, size))
            .map(carMapper::responseEntityToDto);

    log.info("Data loaded from Repository");

    PageResponse<CarResponseDto> response = new PageResponse<>(
            pageData.getContent(),
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
    );

    redisService.setValueS(key, response, 600);
    return response;
  }
}
