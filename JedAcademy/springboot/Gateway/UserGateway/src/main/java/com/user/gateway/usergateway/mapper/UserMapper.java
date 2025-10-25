package com.user.gateway.usergateway.mapper;

import com.user.gateway.usergateway.dao.entity.UserEntity;
import com.user.gateway.usergateway.dto.UserRequestDto;
import com.user.gateway.usergateway.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto entityToDto(UserEntity responseDto);
  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
