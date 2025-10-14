package com.redis.rabbit.page.rabbituser.mapper;

import com.redis.rabbit.page.rabbituser.dao.entity.UserEntity;
import com.redis.rabbit.page.rabbituser.dto.UserRequestDto;
import com.redis.rabbit.page.rabbituser.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto responseEntityToDto(UserEntity responseEntity);
  List<UserResponseDto> responseEntityListToDtoList(List<UserEntity> responseListEntity);
}
