package com.mapper.mapperpractice.mapper;

import com.mapper.mapperpractice.dao.entity.UserEntity;
import com.mapper.mapperpractice.dto.UserRequestDto;
import com.mapper.mapperpractice.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
  public UserEntity UserEntityToDto(UserRequestDto userRequestDto) {
   return UserEntity.builder()
            .fullName(userRequestDto.getFullName())
            .surName(userRequestDto.getSurName())
            .age(userRequestDto.getAge())
            .gender(userRequestDto.getGender())
            .email(userRequestDto.getEmail())
            .userPersonalKey(userRequestDto.getUserPersonalKey())
            .build();
  }

  public List<UserEntity> UserEntityListToDtoList(List<UserRequestDto> userRequestDtoList){
    List<UserEntity> userList = new ArrayList<>();

    for (UserRequestDto users : userRequestDtoList) {
      userList.add(UserEntityToDto(users));
    }

    return userList;
  }

  public UserResponseDto userResponseDto(UserEntity userEntity) {
    return UserResponseDto.builder()
            .fullName(userEntity.getFullName())
            .surName(userEntity.getSurName())
            .age(userEntity.getAge())
            .gender(userEntity.getGender())
            .email(userEntity.getEmail())
            .registeredAt(userEntity.getRegisteredAt())
            .build();
  }

  public List<UserResponseDto> userResponseDtoList(List<UserEntity> userEntityList) {
    List<UserResponseDto> userResponseDtoList = new ArrayList<>();

    for (UserEntity entity:userEntityList){
      userResponseDtoList.add(userResponseDto(entity));
    }
    return userResponseDtoList;
  }
}
