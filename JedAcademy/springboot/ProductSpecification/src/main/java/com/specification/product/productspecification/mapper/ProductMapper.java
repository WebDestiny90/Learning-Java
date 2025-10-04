package com.specification.product.productspecification.mapper;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import com.specification.product.productspecification.dto.ProductRequestDto;
import com.specification.product.productspecification.dto.ProductResponseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductEntity toRequestDto(ProductRequestDto requestDto);
  ProductResponseEntity toResponseDto(ProductEntity responseDto);
}
