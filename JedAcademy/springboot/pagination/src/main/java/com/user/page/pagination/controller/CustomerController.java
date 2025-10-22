package com.user.page.pagination.controller;

import com.user.page.pagination.dto.CustomerFilterDto;
import com.user.page.pagination.dto.CustomerRequestDto;
import com.user.page.pagination.dto.CustomerResponseDto;
import com.user.page.pagination.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public Long addCustomer(@RequestBody CustomerRequestDto requestDto) {
    return customerService.addCustomer(requestDto);
  }

  @GetMapping("/get")
  public ResponseEntity<Page<CustomerResponseDto>> getUsers(CustomerFilterDto filterDto) {
    Page<CustomerResponseDto> customers = customerService.getCustomer(filterDto);
    return customers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(customers);
  }
}
