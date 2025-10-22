package com.user.fileupload.fileupload.mapper;

import com.user.fileupload.fileupload.dao.entity.UserEntity;
import com.user.fileupload.fileupload.dto.UserRequestDto;
import com.user.fileupload.fileupload.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity requestDtoToEntity(UserRequestDto requestDto);
  UserResponseDto entityToDto(UserEntity responseDto);
  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
