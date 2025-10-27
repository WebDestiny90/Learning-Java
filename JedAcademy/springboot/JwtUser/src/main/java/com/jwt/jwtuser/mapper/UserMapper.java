package com.jwt.jwtuser.mapper;

import com.jwt.jwtuser.dao.entity.UserEntity;
import com.jwt.jwtuser.dto.UserRequestDto;
import com.jwt.jwtuser.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto entityToDto(UserEntity responseDto);
  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
