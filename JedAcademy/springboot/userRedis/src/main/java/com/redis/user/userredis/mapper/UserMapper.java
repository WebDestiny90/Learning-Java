package com.redis.user.userredis.mapper;

import com.redis.user.userredis.dao.entity.UserEntity;
import com.redis.user.userredis.dto.UserRequestDto;
import com.redis.user.userredis.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestToEntity(UserRequestDto requestDto);

  List<UserEntity> requestListToEntity(List<UserRequestDto> requestListDto);

  List<UserResponseDto> responseListToDto(List<UserEntity> responseDto);

  UserResponseDto responseToDto(UserEntity userEntity);
}
