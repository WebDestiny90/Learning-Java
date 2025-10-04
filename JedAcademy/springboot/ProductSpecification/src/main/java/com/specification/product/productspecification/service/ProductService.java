package com.specification.product.productspecification.service;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import com.specification.product.productspecification.dao.repository.ProductRepository;
import com.specification.product.productspecification.dto.ProductFilterDto;
import com.specification.product.productspecification.dto.ProductRequestDto;
import com.specification.product.productspecification.dto.ProductResponseDto;
import com.specification.product.productspecification.mapper.ProductMapper;
import com.specification.product.productspecification.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public void addProduct(ProductRequestDto requestDto) {
    productRepository.save(productMapper.toRequestDto(requestDto));
  }

  public Page<ProductResponseDto> getProduct(ProductFilterDto filterDto) {
    Specification<ProductEntity> spec = ProductSpecification.filter(filterDto);
    Page<ProductEntity> page = productRepository.findAll(spec, PageRequest.of(filterDto.getPage(),filterDto.getSize()));

    return page.map(productMapper::toResponseDto);
  }
}
