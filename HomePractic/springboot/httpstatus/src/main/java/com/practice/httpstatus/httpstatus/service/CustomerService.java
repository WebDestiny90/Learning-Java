package com.practice.httpstatus.httpstatus.service;

import com.practice.httpstatus.httpstatus.dao.entity.CustomerEntity;
import com.practice.httpstatus.httpstatus.dao.repository.CustomerRepository;
import com.practice.httpstatus.httpstatus.dto.CustomerFilterDto;
import com.practice.httpstatus.httpstatus.dto.CustomerRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerResponseDto;
import com.practice.httpstatus.httpstatus.mapper.CustomerMapper;
import com.practice.httpstatus.httpstatus.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public void addUser(CustomerRequestDto requestDto) {
    customerRepository.save(customerMapper.requestToDto(requestDto));
  }

  public Page<CustomerResponseDto> getUser(CustomerFilterDto filterDto){
    Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize());

    Specification<CustomerEntity> specification = Specification.allOf(
            CustomerSpecification.hasName(filterDto.getFullName()),
            CustomerSpecification.hasSurName(filterDto.getSurName()),
            CustomerSpecification.hasEmail(filterDto.getEmail()),
            CustomerSpecification.hasPassword(filterDto.getPassword())
    );
    Page<CustomerEntity> page = customerRepository.findAll(specification, pageable);

    return page.map(customerMapper::responseToDto);
  }
}
