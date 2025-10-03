package com.practice.openfeign.productserver.mapper;

import com.practice.openfeign.productserver.dao.entity.ProductEntity;
import com.practice.openfeign.productserver.dto.ProductRequestDto;
import com.practice.openfeign.productserver.dto.ProductResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductEntity toRequestDto(ProductRequestDto productRequestDto);
  ProductResponseDto toResponseDto(ProductEntity productResponseDto);
}
