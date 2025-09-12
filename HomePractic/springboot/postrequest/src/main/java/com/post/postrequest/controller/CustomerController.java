package com.post.postrequest.controller;


import com.post.postrequest.dao.entity.CustomerEntity;
import com.post.postrequest.dto.CustomerRequestRecord;
import com.post.postrequest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
  private final CustomerService customerService;

  @GetMapping
  public List<CustomerEntity> getCustomer() {
    return customerService.getUsers();
  }


  @PostMapping
  public Long addCustomer(@RequestBody CustomerRequestRecord customerRequest) {
    return customerService.addCustomer(customerRequest);
  }
}
