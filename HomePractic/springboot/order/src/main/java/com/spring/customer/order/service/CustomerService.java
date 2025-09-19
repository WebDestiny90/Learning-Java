package com.spring.customer.order.service;

import com.spring.customer.order.dao.repository.CustomerRepository;
import com.spring.customer.order.dto.CustomerRequestDto;
import com.spring.customer.order.dto.CustomerResponseDto;
import com.spring.customer.order.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public void addCustomer(CustomerRequestDto customerRequestDto) {
    customerRepository.save(customerMapper.dtoToEntity(customerRequestDto));
  }

  public List<CustomerResponseDto> getCustomer() {
    return customerMapper.toDto(customerRepository.findAll());
  }
}
