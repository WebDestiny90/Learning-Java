package com.rabbit.fanout.topic.rabbtifanout.mapper;

import com.rabbit.fanout.topic.rabbtifanout.dao.entity.UserEntity;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserRequestDto;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto responseEntityToDto(UserEntity responseEntity);
  List<UserResponseDto> responseEntityListToDtoList(List<UserEntity> responseListEntity);
}
