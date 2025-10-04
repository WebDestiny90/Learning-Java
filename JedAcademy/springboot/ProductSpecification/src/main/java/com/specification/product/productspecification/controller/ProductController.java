package com.specification.product.productspecification.controller;

import com.specification.product.productspecification.dto.ProductFilterDto;
import com.specification.product.productspecification.dto.ProductRequestDto;
import com.specification.product.productspecification.dto.ProductResponseDto;
import com.specification.product.productspecification.mapper.ProductMapper;
import com.specification.product.productspecification.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;
  private final ProductMapper productMapper;

  @PostMapping("/add")
  public ResponseEntity<String> addProduct(@Valid @RequestBody ProductRequestDto requestDto) {
    productService.addProduct(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Products Successfully created!");
  }

  @PostMapping("/addProducts")
  public ResponseEntity<String> addProduct(@Valid @RequestBody List<ProductRequestDto> requestDto) {
    productService.addProducts(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Product Successfully created!");
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<ProductResponseDto> updateProduct(
          @PathVariable Long id,
          @RequestBody ProductRequestDto requestDto) {

    var updatedProduct = productService.updateProduct(requestDto, id);
    var responseDto = productMapper.toResponseDto(updatedProduct);

    return ResponseEntity.ok(responseDto);
  }

  @GetMapping("/get")
  public ResponseEntity<Page<ProductResponseDto>> getProduct(ProductFilterDto filterDto) {
      var product = productService.getProduct(filterDto);
      return product.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
  }
}
