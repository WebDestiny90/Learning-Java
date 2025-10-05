package com.specification.product.productspecification.service;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import com.specification.product.productspecification.dao.repository.ProductRepository;
import com.specification.product.productspecification.dto.ProductFilterDto;
import com.specification.product.productspecification.dto.ProductRequestDto;
import com.specification.product.productspecification.dto.ProductResponseDto;
import com.specification.product.productspecification.exception.InvalidProductException;
import com.specification.product.productspecification.mapper.ProductMapper;
import com.specification.product.productspecification.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public void addProduct(ProductRequestDto requestDto) {
    productRepository.save(productMapper.toRequestDto(requestDto));
  }

  public List<Long> addProducts(List<ProductRequestDto> requestDto) {
   List<ProductEntity> entities = productMapper.toRequestListDto(requestDto);
   List<ProductEntity> savedEntities = productRepository.saveAll(entities);
   return savedEntities.stream().map(ProductEntity::getId).toList();
  }

  public ProductEntity updateProduct(ProductRequestDto requestDto, Long id) {
    return productRepository.findById(id)
            .map(product -> {
              product.setTitle(requestDto.getTitle());
              product.setDescription(requestDto.getDescription());
              product.setPrice(requestDto.getPrice());
              product.setStock(requestDto.getStock());
              product.setBrand(requestDto.getBrand());
              product.setCategory(requestDto.getCategory());
              product.setActive(requestDto.getActive());
              product.setRating(requestDto.getRating());
              return productRepository.save(product);
            })
            .orElseThrow(() -> new InvalidProductException("Oops! Product with ID " + id + " not found"));
  }

  public Page<ProductResponseDto> getProduct(ProductFilterDto filterDto) {

    Specification<ProductEntity> spec = ProductSpecification.filter(filterDto);
    var sort = filterDto.getAsc() ? Sort.by(filterDto.getSortBy()).ascending() : Sort.by(filterDto.getSortBy()).descending();
    var pageable = PageRequest.of(filterDto.getPage(),filterDto.getSize(),sort);
    var page = productRepository.findAll(spec, pageable);

    return page.map(productMapper::toResponseDto);
  }
}
