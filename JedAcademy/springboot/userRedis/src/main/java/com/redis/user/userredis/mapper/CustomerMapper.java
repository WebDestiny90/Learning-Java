package com.redis.user.userredis.mapper;

import com.redis.user.userredis.dao.entity.CustomerEntity;
import com.redis.user.userredis.dto.CustomerRequestDto;
import com.redis.user.userredis.dto.CustomerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerEntity requestDtoToEntity(CustomerRequestDto requestDto);
  List<CustomerEntity> requestListToDtoEntity(List<CustomerRequestDto> requestDtoList);
  CustomerResponseDto responseToDto(CustomerEntity responseDto);
  List<CustomerResponseDto> responseListToDto(List<CustomerEntity> responseListDto);
}
