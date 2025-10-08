package com.redis.car.rediscar.mapper;

import com.redis.car.rediscar.dao.entity.CarEntity;
import com.redis.car.rediscar.dto.CarRequestDto;
import com.redis.car.rediscar.dto.CarResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
  CarEntity requestDtoToEntity(CarRequestDto requestDto);
  CarResponseDto entityToResponseDto(CarEntity responseEntity);
}
