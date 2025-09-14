package com.post.crud.mapper;

import com.post.crud.dao.entity.CarEntity;
import com.post.crud.dto.CarResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
  public CarResponseDto carEntityToDto(CarEntity carEntity) {
    return CarResponseDto.builder()
            .mark(carEntity.getMark())
            .model(carEntity.getModel())
            .year(carEntity.getYear())
            .engine(carEntity.getEngine())
            .color(carEntity.getColor())
            .fuelType(carEntity.getFuelType())
            .build();
  }

  public CarEntity carDtoToEntity(CarResponseDto carResponseDto) {
    return CarEntity.builder()
            .mark(carResponseDto.getMark())
            .model(carResponseDto.getModel())
            .year(carResponseDto.getYear())
            .engine(carResponseDto.getEngine())
            .color(carResponseDto.getColor())
            .fuelType(carResponseDto.getFuelType())
            .build();
  }

  public List<CarResponseDto> carListEntityToDto(List<CarEntity> carEntity) {
    List<CarResponseDto> carList = new ArrayList<>();

    for (CarEntity cars : carEntity) {
      carList.add(carEntityToDto(cars));
    }
    return carList;
  }
}
