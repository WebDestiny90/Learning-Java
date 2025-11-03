package com.practice.openfeign.productclient.client;

import com.practice.openfeign.productclient.dto.ProductFilterDto;
import com.practice.openfeign.productclient.dto.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product", url = "http://localhost:8081/api/v1/product")
public interface ProductList {

  @GetMapping("/get")
  Page<ProductResponseDto> getProduct(@SpringQueryMap ProductFilterDto filterDto);
}

