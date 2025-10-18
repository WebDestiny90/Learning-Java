package com.manytoone.manytoone.mapper;

import com.manytoone.manytoone.dao.entity.ProductEntity;
import com.manytoone.manytoone.dto.ProductRequestDto;
import com.manytoone.manytoone.dto.ProductResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductEntity toEntity(ProductRequestDto dto);
  ProductResponseDto toDto(ProductEntity entity);;
}
