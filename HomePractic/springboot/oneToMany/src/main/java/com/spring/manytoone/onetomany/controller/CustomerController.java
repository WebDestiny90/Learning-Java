package com.spring.manytoone.onetomany.controller;

import com.spring.manytoone.onetomany.dao.repository.CustomerRepository;
import com.spring.manytoone.onetomany.dto.CustomerResponseDto;
//import com.spring.manytoone.onetomany.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerRepository customerRepository;

  @GetMapping("/{id}")
  public CustomerResponseDto getUser(@PathVariable Long id) {
    var customer = customerRepository.findById(id).orElseThrow();
//   return CustomerMapper.INSTANCE.toDto(customer);
    return null;
  }
}
