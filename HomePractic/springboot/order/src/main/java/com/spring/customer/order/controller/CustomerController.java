package com.spring.customer.order.controller;

import com.spring.customer.order.dto.CustomerRequestDto;
import com.spring.customer.order.dto.CustomerResponseDto;
import com.spring.customer.order.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public void addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
    customerService.addCustomer(customerRequestDto);
  }

  @GetMapping("/get")
  public List<CustomerResponseDto> getCustomer() {
   return customerService.getCustomer();
  }
}
