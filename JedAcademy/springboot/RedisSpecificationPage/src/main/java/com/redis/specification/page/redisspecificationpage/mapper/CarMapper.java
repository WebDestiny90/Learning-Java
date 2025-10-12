package com.redis.specification.page.redisspecificationpage.mapper;

import com.redis.specification.page.redisspecificationpage.dao.entity.CarEntity;
import com.redis.specification.page.redisspecificationpage.dto.CarRequestDto;
import com.redis.specification.page.redisspecificationpage.dto.CarResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
  CarEntity requestDtoToEntity(CarRequestDto requestDto);
  List<CarEntity> requestListToEntityList(List<CarRequestDto> requestDtoList);

  CarResponseDto responseEntityToDto(CarEntity responseEntity);
  List<CarResponseDto> responseListEntityToDtoList(List<CarEntity> responseEntityList);
}
