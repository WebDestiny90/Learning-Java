package com.manytoone.manytoone.mapper;

import com.manytoone.manytoone.dao.entity.CategoryEntity;
import com.manytoone.manytoone.dto.CategoryRequestDto;
import com.manytoone.manytoone.dto.CategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryEntity RequestDtoToEntity(CategoryRequestDto requestDto);

  @Mapping(target = "product", source = "products")
  CategoryResponseDto EntityToResponseDto(CategoryEntity entity);
}
