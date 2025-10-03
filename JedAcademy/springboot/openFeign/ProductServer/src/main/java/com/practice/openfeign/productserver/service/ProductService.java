package com.practice.openfeign.productserver.service;

import com.practice.openfeign.productserver.dao.entity.ProductEntity;
import com.practice.openfeign.productserver.dao.repository.ProductRepository;
import com.practice.openfeign.productserver.dto.ProductFilterDto;
import com.practice.openfeign.productserver.dto.ProductRequestDto;
import com.practice.openfeign.productserver.dto.ProductResponseDto;
import com.practice.openfeign.productserver.mapper.ProductMapper;
import com.practice.openfeign.productserver.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public void addProduct(ProductRequestDto productRequestDto) {
    productRepository.save(productMapper.toRequestDto(productRequestDto));
  }

  public Page<ProductResponseDto> getProducts(ProductFilterDto filterDto) {
    Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());

    Specification<ProductEntity> specification = Specification.allOf(
            ProductSpecification.hasTitle(filterDto.getTitle()),
            ProductSpecification.hasPrice(filterDto.getPrice()),
            ProductSpecification.hasStock(filterDto.getStock())
    );
    Page<ProductEntity> products = productRepository.findAll(specification, pageable);

    return products.map(productMapper::toResponseDto);
  }
}
