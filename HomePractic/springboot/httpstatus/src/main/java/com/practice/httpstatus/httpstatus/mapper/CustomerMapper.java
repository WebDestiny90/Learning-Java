package com.practice.httpstatus.httpstatus.mapper;

import com.practice.httpstatus.httpstatus.dao.entity.AuthEntity;
import com.practice.httpstatus.httpstatus.dao.entity.CustomerEntity;
import com.practice.httpstatus.httpstatus.dto.AuthRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerRequestDto;
import com.practice.httpstatus.httpstatus.dto.CustomerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  CustomerEntity requestToDto (CustomerRequestDto requestDto);

  AuthEntity authToDto(AuthRequestDto authRequestDto);

  CustomerResponseDto responseToDto (CustomerEntity responseDto);
}
