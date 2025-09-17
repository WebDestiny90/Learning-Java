package com.spring.mapstruct.mapstruct.mapper;

import com.spring.mapstruct.mapstruct.dao.entity.CustomerEntity;
import com.spring.mapstruct.mapstruct.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMap {
  public CustomerDto entityToDto(CustomerEntity customer) {
    return CustomerDto.builder().customerName(customer.getCustomerName()).build();
  }
}
