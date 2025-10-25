package com.car.gateway.cargateway.mapper;


import com.car.gateway.cargateway.dao.entity.CarEntity;
import com.car.gateway.cargateway.dto.CarRequestDto;
import com.car.gateway.cargateway.dto.CarResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
  public CarEntity requestDtoToEntity(CarRequestDto requestDto) {
    return CarEntity.builder()
            .brand(requestDto.getBrand())
            .model(requestDto.getModel())
            .year(requestDto.getYear())
            .fuelType(requestDto.getFuelType())
            .transmission(requestDto.getTransmission())
            .type(requestDto.getType())
            .price(requestDto.getPrice())
            .mileage(requestDto.getMileage())
            .color(requestDto.getColor())
            .available(requestDto.getAvailable())
            .description(requestDto.getDescription())
            .build();
  }

  public List<CarEntity> requestDtoListToEntityList(List<CarRequestDto> requestDtoLists) {
    List<CarEntity> requestList = new ArrayList<>();
    for (CarRequestDto cars : requestDtoLists) {
      requestList.add(requestDtoToEntity(cars));
    }
    return requestList;
  }

  public CarResponseDto entityToDto(CarEntity responseEntity) {
    return CarResponseDto.builder()
            .brand(responseEntity.getBrand())
            .model(responseEntity.getModel())
            .year(responseEntity.getYear())
            .fuelType(responseEntity.getFuelType())
            .transmission(responseEntity.getTransmission())
            .type(responseEntity.getType())
            .price(responseEntity.getPrice())
            .mileage(responseEntity.getMileage())
            .color(responseEntity.getColor())
            .available(responseEntity.getAvailable())
            .description(responseEntity.getDescription())
            .createdAt(responseEntity.getCreatedAt())
            .updatedAt(responseEntity.getUpdatedAt())
            .build();
  }

  public List<CarResponseDto> responseDtoListToEntity(List<CarEntity> responseDtoList) {
    List<CarResponseDto> responseList = new ArrayList<>();
    for (CarEntity carResponse:responseDtoList) {
      responseList.add(entityToDto(carResponse));
    }
    return responseList;
  }
}
