package com.springsecurity.springsecurity.mapper;

import com.springsecurity.springsecurity.dao.entity.UserEntity;
import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity toEntity(UserRequestDto requestEntityDto);

  @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
  UserEntity requestDtoToEntity(UserRequestDto requestDto, @Context BCryptPasswordEncoder encoder);

  @Named("encodePassword")
  default String encodePassword(String password, @Context BCryptPasswordEncoder encoder) {
    return encoder.encode(password);
  }

  UserResponseDto entityToDto(UserEntity responseDto);
  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
