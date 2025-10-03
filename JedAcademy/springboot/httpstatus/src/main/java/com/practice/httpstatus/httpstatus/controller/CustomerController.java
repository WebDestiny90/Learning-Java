package com.practice.httpstatus.httpstatus.controller;

import com.practice.httpstatus.httpstatus.dto.AuthRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerFilterDto;
import com.practice.httpstatus.httpstatus.dto.CustomerRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerResponseDto;
import com.practice.httpstatus.httpstatus.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping("/add")
  public ResponseEntity<String> addCustomer(@RequestBody CustomerRequestDto requestDto) {
    customerService.addUser(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("User has been successfully created.");
  }

  @PostMapping("/auth")
  public ResponseEntity<String> addAuth(@Valid @RequestBody AuthRequestDto authRequestDto) {
    customerService.auth(authRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Auth has been created successfully.");
  }

  @GetMapping("/get")
  public ResponseEntity<Page<CustomerResponseDto>> getCustomer(CustomerFilterDto filterDto) {

    Page<CustomerResponseDto> customer = customerService.getUser(filterDto);

    return customer.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(customer);
  }
}
