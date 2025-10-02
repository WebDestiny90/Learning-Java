package com.practice.httpstatus.httpstatus.controller;

import com.practice.httpstatus.httpstatus.dto.CustomerFilterDto;
import com.practice.httpstatus.httpstatus.dto.CustomerRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerResponseDto;
import com.practice.httpstatus.httpstatus.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public void addCustomer(@RequestBody CustomerRequestDto requestDto) {
    customerService.addUser(requestDto);
  }

  @GetMapping("/get")
  public Page<CustomerResponseDto> getCustomer(CustomerFilterDto filterDto) {

    return customerService.getUser(filterDto);
  }
}
