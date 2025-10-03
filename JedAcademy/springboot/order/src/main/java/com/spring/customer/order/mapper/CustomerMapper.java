package com.spring.customer.order.mapper;


import com.spring.customer.order.dao.entity.CustomerEntity;
import com.spring.customer.order.dto.CustomerRequestDto;
import com.spring.customer.order.dto.CustomerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerEntity dtoToEntity(CustomerRequestDto customerRequestDto);

  List<CustomerResponseDto> toDto(List<CustomerEntity> customerEntities);
}
