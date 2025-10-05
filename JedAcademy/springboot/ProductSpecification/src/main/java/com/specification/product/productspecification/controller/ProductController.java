package com.specification.product.productspecification.controller;

import com.specification.product.productspecification.dto.ProductCreationResponse;
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
            .body("Product Successfully created!");
  }

  @PostMapping("/addProducts")
  public ResponseEntity<ProductCreationResponse> addProducts(@RequestBody List<@Valid ProductRequestDto> requestDto) {
   List<Long> createdIds = productService.addProducts(requestDto);

    ProductCreationResponse response = new ProductCreationResponse(
            "Products Successfully created!",
            createdIds
    );

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<ProductResponseDto> updateProduct(
          @PathVariable Long id,
          @RequestBody ProductRequestDto requestDto) {

    var updatedProduct = productService.updateProduct(requestDto, id);
    var responseDto = productMapper.toResponseDto(updatedProduct);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
  }

  @GetMapping("/get")
  public ResponseEntity<Page<ProductResponseDto>> getProduct(ProductFilterDto filterDto) {
      var product = productService.getProduct(filterDto);
      return product.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
  }
}
