package com.practice.openfeign.productserver.controller;

import com.practice.openfeign.productserver.dto.ProductFilterDto;
import com.practice.openfeign.productserver.dto.ProductRequestDto;
import com.practice.openfeign.productserver.dto.ProductResponseDto;
import com.practice.openfeign.productserver.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping("/add")
  public ResponseEntity<String> addProduct(@Valid @RequestBody ProductRequestDto requestDto) {
    productService.addProduct(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body("Product Successfully created");
  }

  @GetMapping("/get")
  public ResponseEntity<Page<ProductResponseDto>> getProduct(ProductFilterDto filterDto) {
    Page<ProductResponseDto> products = productService.getProducts(filterDto);

    return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
  }
}
