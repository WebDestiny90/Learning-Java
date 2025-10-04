package com.specification.product.productspecification.mapper;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import com.specification.product.productspecification.dto.ProductRequestDto;
import com.specification.product.productspecification.dto.ProductResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductEntity toRequestDto(ProductRequestDto requestDto);
  List<ProductEntity> toRequestListDto(List<ProductRequestDto> requestDtoList);
  ProductResponseDto toResponseDto(ProductEntity responseDto);
}
