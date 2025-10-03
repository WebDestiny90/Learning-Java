package com.practice.openfeign.productclient.controller;

import com.practice.openfeign.productclient.client.ProductList;
import com.practice.openfeign.productclient.dto.ProductFilterDto;
import com.practice.openfeign.productclient.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductList productList;

  @GetMapping("/get")
  Page<ProductResponseDto> getProduct(ProductFilterDto filterDto) {
    return productList.getProduct(filterDto);
  }
}
