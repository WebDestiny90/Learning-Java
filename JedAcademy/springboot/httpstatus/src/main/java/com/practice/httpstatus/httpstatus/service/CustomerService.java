package com.practice.httpstatus.httpstatus.service;

import com.practice.httpstatus.httpstatus.dao.entity.AuthEntity;
import com.practice.httpstatus.httpstatus.dao.entity.CustomerEntity;
import com.practice.httpstatus.httpstatus.dao.repository.AuthRepository;
import com.practice.httpstatus.httpstatus.dao.repository.CustomerRepository;
import com.practice.httpstatus.httpstatus.dto.*;
import com.practice.httpstatus.httpstatus.exception.InvalidPasswordException;
import com.practice.httpstatus.httpstatus.mapper.CustomerMapper;
import com.practice.httpstatus.httpstatus.specification.CustomerSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;
  private final AuthRepository authRepository;

  public void addUser(CustomerRequestDto requestDto) {
    customerRepository.save(customerMapper.requestToDto(requestDto));
  }

  @Transactional
  public void auth( AuthRequestDto authRequestDto) {

    authRepository.save(customerMapper.authToDto(authRequestDto));
    if (!PasswordValidator.isValidPassword(authRequestDto.getPassword())) {
      throw new InvalidPasswordException("Parol tələblərə cavab vermir!");
    }
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
