package com.spring.mapstruct.mapstruct.mapper;

import com.spring.mapstruct.mapstruct.dao.entity.UserEntity;
import com.spring.mapstruct.mapstruct.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserResponseDto entityToDto(UserEntity userEntity);
  UserEntity dtoToEntity(UserResponseDto userResponseDto);
  List<UserResponseDto> entityListToDto(List<UserEntity> userEntityList);

}