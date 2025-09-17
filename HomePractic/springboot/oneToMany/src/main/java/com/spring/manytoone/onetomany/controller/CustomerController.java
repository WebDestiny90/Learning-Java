package com.spring.manytoone.onetomany.controller;

import com.spring.manytoone.onetomany.dao.entity.CustomerEntity;
import com.spring.manytoone.onetomany.dao.repository.CustomerRepository;
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
  public CustomerEntity getUser(@PathVariable Long id) {
    return customerRepository.findById(id).orElseThrow();

  }
}
