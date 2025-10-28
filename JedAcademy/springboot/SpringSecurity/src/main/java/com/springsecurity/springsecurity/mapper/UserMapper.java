package com.springsecurity.springsecurity.mapper;

import com.springsecurity.springsecurity.dao.entity.UserEntity;
import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto entityToDto(UserEntity responseDto);
  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
