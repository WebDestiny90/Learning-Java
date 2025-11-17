package com.comebackpraktika.mapper;

import com.comebackpraktika.dao.entity.ComebackEntity;
import com.comebackpraktika.dto.ComebackRequestDto;
import com.comebackpraktika.dto.ComebackResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComebackMapper {
  ComebackEntity toEntity(ComebackRequestDto requestDto);
  List<ComebackEntity> toEntityList(List<ComebackRequestDto> requestDtoList);

  ComebackResponseDto toDto(ComebackEntity responseDto);
  List<ComebackResponseDto> toDtoList(List<ComebackEntity> responseDtoList);
}
