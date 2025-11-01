package com.ticket.aviaticket.controller;

import com.ticket.aviaticket.dto.CustomerRequestDto;
import com.ticket.aviaticket.dto.CustomerResponseDto;
import com.ticket.aviaticket.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("addcustomer")
  public void addCustomer(@RequestBody CustomerRequestDto requestDto) {
    customerService.save(requestDto);
  }

  @GetMapping("/getcustomer")
  public List<CustomerResponseDto> getAllCustomers(CustomerResponseDto responseDto) {
    return customerService.getAllCustomers();
  }
}
