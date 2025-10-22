package com.user.page.pagination.service;

import com.user.page.pagination.dao.entity.CustomerEntity;
import com.user.page.pagination.dao.repository.CustomerRepository;
import com.user.page.pagination.dto.CustomerFilterDto;
import com.user.page.pagination.dto.CustomerRequestDto;
import com.user.page.pagination.dto.CustomerResponseDto;
import com.user.page.pagination.mapper.CustomerMapper;
import com.user.page.pagination.specification.CustomerSpecification;
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

  public Long addCustomer(CustomerRequestDto requestDto) {
    var savedCustomer = customerRepository.save(customerMapper.requestDtoTOEntity(requestDto));
    return savedCustomer.getId();
  }

  public Page<CustomerResponseDto> getCustomer(CustomerFilterDto filterDto) {
    Pageable pageable = PageRequest.of(filterDto.getPage(),filterDto.getSize());

    Specification<CustomerEntity> spec = Specification.allOf(
            CustomerSpecification.hasName(filterDto.getName()),
            CustomerSpecification.hasSurName(filterDto.getSurName()),
            CustomerSpecification.hasAge(filterDto.getAge())
    );
    Page<CustomerEntity> customers = customerRepository.findAll(spec, pageable);
    return customers.map(customerMapper::responseToDto);
  }
}
