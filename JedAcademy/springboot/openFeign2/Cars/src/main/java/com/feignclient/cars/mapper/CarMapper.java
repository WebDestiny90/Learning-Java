package com.feignclient.cars.mapper;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dto.CarRequestDto;
import com.feignclient.cars.dto.CarResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
  CarEntity dtoToEntity(CarRequestDto requestDto);
  List<CarEntity> dtoListToEntityList(List<CarRequestDto> requestDtoList);
  CarResponseDto entityToDto(CarResponseDto responseDto);
  List<CarResponseDto> entityListToDtoList(List<CarEntity> responseDtoList);
}
