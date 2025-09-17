package com.spring.mapstruct.mapstruct.service;

import com.spring.mapstruct.mapstruct.dao.entity.CustomerEntity;
import com.spring.mapstruct.mapstruct.dao.repository.CustomerRepository;
import com.spring.mapstruct.mapstruct.dto.CustomerDto;
import com.spring.mapstruct.mapstruct.mapper.CustomerMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMap customerMap;
  public CustomerDto getSomeCustomer(Long id) {

    var customer = customerRepository.findCustomer(id).orElse(new CustomerEntity());

    return customerMap.entityToDto(customer);
  }
}
