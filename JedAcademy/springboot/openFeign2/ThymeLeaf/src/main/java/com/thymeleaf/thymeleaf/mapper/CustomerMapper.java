package com.thymeleaf.thymeleaf.mapper;

import com.thymeleaf.thymeleaf.dao.entity.CustomerEntity;
import com.thymeleaf.thymeleaf.dto.CustomerRequestDto;
import com.thymeleaf.thymeleaf.dto.CustomerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerEntity entityToDto(CustomerRequestDto requestDto);
  CustomerResponseDto dtoToEntity(CustomerEntity responseDto);
  List<CustomerResponseDto> dtoToEntityList(List<CustomerEntity> responseDto);
}
