package com.spec.pageandspecification.mapper;

import com.spec.pageandspecification.dao.entity.CarEntity;
import com.spec.pageandspecification.dto.CarRequestDto;
import com.spec.pageandspecification.dto.CarResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
  CarEntity toDto(CarRequestDto requestDto);

  CarResponseDto toResponseDto(CarEntity carResponseEntity);
}
