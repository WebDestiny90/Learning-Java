package com.thymeleaf.thymeleaf.service;

import com.thymeleaf.thymeleaf.dao.repository.CustomerRepository;
import com.thymeleaf.thymeleaf.dto.CustomerRequestDto;
import com.thymeleaf.thymeleaf.dto.CustomerResponseDto;
import com.thymeleaf.thymeleaf.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public Long addCustomer(CustomerRequestDto requestDto) {
    return customerRepository.save(customerMapper.entityToDto(requestDto)).getId();
  }

  public List<CustomerResponseDto> getUsers() {
    return customerRepository.findAll().stream().map(customerMapper::dtoToEntity).toList();
  }
}
