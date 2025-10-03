package com.spring.order.customerserver.client;

import com.spring.order.customerserver.dto.CountResponseDto;
import com.spring.order.customerserver.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customers", url = "https://olsun.in/api/jet/student")
public interface CustomersOrder {

  @GetMapping("/get")
  CountResponseDto getCustomer();
}
