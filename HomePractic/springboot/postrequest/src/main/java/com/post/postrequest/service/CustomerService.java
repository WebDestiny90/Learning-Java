package com.post.postrequest.service;


import com.post.postrequest.dao.entity.CustomerEntity;
import com.post.postrequest.dao.repository.CustomerRepository;
import com.post.postrequest.dto.CustomerRequestRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;


  public List<CustomerEntity> getUsers() {
    return customerRepository.findAll();
  }

  public Long addCustomer(CustomerRequestRecord customerRecord) {
    var customer = CustomerEntity.builder().name(customerRecord.name()).build();
    return customerRepository.save(customer).getId();
  }

}
