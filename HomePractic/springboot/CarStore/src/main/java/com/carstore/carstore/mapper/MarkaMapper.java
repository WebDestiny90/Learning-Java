package com.carstore.carstore.mapper;

import com.carstore.carstore.dao.entity.MarksEntity;
import com.carstore.carstore.dto.MarkRequestDto;
import com.carstore.carstore.dto.MarkResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkaMapper {
  MarksEntity dtoToEntity(MarkRequestDto markRequestDto);

  List<MarkResponseDto> toDto(List<MarksEntity> marksEntities);
}
