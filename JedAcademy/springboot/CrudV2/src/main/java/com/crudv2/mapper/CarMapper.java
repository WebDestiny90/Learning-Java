package com.crudv2.mapper;

import com.crudv2.dao.entity.CarEntity;
import com.crudv2.dto.CarResponseDto;
import com.crudv2.dto.CarRequestDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
  public CarEntity requestDtoToEntity(CarRequestDto requestDto) {
    return CarEntity.builder()
            .model(requestDto.getModel())
            .brand(requestDto.getBrand())
            .year(requestDto.getYear())
            .price(requestDto.getPrice())
            .engine(requestDto.getEngine())
            .color(requestDto.getColor())
            .fuelType(requestDto.getFuelType())
            .build();
  }

  public List<CarEntity> requestDtoListToEntityList(List<CarRequestDto> requestDtoList) {
    List<CarEntity> dtoList = new ArrayList<>();
    for (CarRequestDto requestList : requestDtoList) {
      dtoList.add(requestDtoToEntity(requestList));
    }
    return dtoList;
  }

  public CarResponseDto responseEntityToDto(CarEntity responseDto) {
    return CarResponseDto.builder()
            .id(responseDto.getId())
            .model(responseDto.getModel())
            .brand(responseDto.getBrand())
            .year(responseDto.getYear())
            .price(responseDto.getPrice())
            .engine(responseDto.getEngine())
            .color(responseDto.getColor())
            .fuelType(responseDto.getFuelType())
            .createdAt(responseDto.getCreatedAt())
            .updatedAt(responseDto.getUpdatedAt())
            .deletedAt(responseDto.getDeletedAt())
            .build();
  }
}
