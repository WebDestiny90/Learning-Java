package com.user.page.pagination.mapper;

import com.user.page.pagination.dao.entity.CustomerEntity;
import com.user.page.pagination.dto.CustomerRequestDto;
import com.user.page.pagination.dto.CustomerResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
  public CustomerEntity requestDtoTOEntity(CustomerRequestDto requestDto) {
    return CustomerEntity.builder()
            .fullName(requestDto.getFullName())
            .surName(requestDto.getSurName())
            .age(requestDto.getAge())
            .build();
  }

  public CustomerResponseDto responseToDto(CustomerEntity responseDto) {
    return CustomerResponseDto.builder()
            .fullName(responseDto.getFullName())
            .surName(responseDto.getSurName())
            .age(responseDto.getAge())
            .build();
  }

  public List<CustomerResponseDto> responseDtoList(List<CustomerEntity> responseListDto) {
    List<CustomerResponseDto> customers = new ArrayList<>();
    for (CustomerEntity entity : responseListDto) {
      customers.add(responseToDto(entity));
    }
    return customers;
  }

}
