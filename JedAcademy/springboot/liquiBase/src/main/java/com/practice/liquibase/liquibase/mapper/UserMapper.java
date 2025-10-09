package com.practice.liquibase.liquibase.mapper;

import com.practice.liquibase.liquibase.dao.entity.UserEntity;
import com.practice.liquibase.liquibase.dto.UserRequestDto;
import com.practice.liquibase.liquibase.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestToEntity(UserRequestDto requestDto);

  List<UserEntity> requestListToEntity(List<UserRequestDto> requestListDto);

  List<UserResponseDto> responseListToDto(List<UserEntity> responseDto);

  UserResponseDto responseToDto(UserEntity userEntity);
}
