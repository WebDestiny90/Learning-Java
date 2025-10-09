package com.redis.user.userredis.controller;

import com.redis.user.userredis.dto.CustomerRequestDto;
import com.redis.user.userredis.dto.CustomerResponseDto;
import com.redis.user.userredis.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public void addCustomer(@RequestBody CustomerRequestDto requestDto) {
    customerService.addCustomer(requestDto);
  }

  @PostMapping("/addList")
  public void addCustomers(@RequestBody List<CustomerRequestDto> requestDtoList) {
    customerService.addCustomers(requestDtoList);
  }

  @GetMapping("/get")
  public CustomerResponseDto getCustomerById(Long id) {
    return customerService.getUserById(id);
  }

  @GetMapping("getList")
  public List<CustomerResponseDto> getCustomers() {
    return customerService.getCustomers();
  }
}
