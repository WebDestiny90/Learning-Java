package com.thymeleaf.thymeleaf.controller;

import com.thymeleaf.thymeleaf.dto.CustomerRequestDto;
import com.thymeleaf.thymeleaf.dto.CustomerResponseDto;
import com.thymeleaf.thymeleaf.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public Long addUser(@RequestBody CustomerRequestDto requestDto) {
    return customerService.addCustomer(requestDto);
  }

  @GetMapping("/get")
  public ResponseEntity<List<CustomerResponseDto>> getUsers() {
    var customers = customerService.getUsers();
    return customers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(customers);
  }
}
