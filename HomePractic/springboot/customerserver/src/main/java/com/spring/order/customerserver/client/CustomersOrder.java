package com.spring.order.customerserver.client;

import com.spring.order.customerserver.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customers", url = "http://localhost:8080/api/v1/customer")
public interface CustomersOrder {

  @GetMapping("/get")
  List<CustomerResponseDto> getCustomer();
}
