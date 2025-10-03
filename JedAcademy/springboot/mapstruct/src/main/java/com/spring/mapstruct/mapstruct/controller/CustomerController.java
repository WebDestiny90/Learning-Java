package com.spring.mapstruct.mapstruct.controller;


import com.spring.mapstruct.mapstruct.dto.CustomerDto;
import com.spring.mapstruct.mapstruct.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;
  @GetMapping("/single")
  public CustomerDto getSomeCustomer(@RequestParam("id") Long id) {
    return customerService.getSomeCustomer(id);
  }
}
