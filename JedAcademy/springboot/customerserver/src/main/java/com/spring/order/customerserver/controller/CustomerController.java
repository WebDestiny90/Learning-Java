package com.spring.order.customerserver.controller;

import com.spring.order.customerserver.client.CustomersOrder;
import com.spring.order.customerserver.dto.CountResponseDto;
import com.spring.order.customerserver.dto.CustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/huseyn")
@RequiredArgsConstructor
public class CustomerController {
  public final CustomersOrder customersOrder;

  @GetMapping("/get")
  CountResponseDto getCustomer() {
    return customersOrder.getCustomer();
  }
}