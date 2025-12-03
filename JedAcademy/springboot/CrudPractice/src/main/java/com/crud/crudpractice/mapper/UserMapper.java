package com.crud.crudpractice.mapper;

import com.crud.crudpractice.dao.entity.UserEntity;
import com.crud.crudpractice.dto.UserRequestDto;
import com.crud.crudpractice.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
  public UserEntity requestDtoToEntity(UserRequestDto requestDto) {
   return UserEntity.builder()
            .firstName(requestDto.getFirstName())
            .lastName(requestDto.getLastName())
            .age(requestDto.getAge())
            .build();
  }

  public List<UserEntity> requestDtoListToEntityList(List<UserRequestDto> requestDtoList) {
    List<UserEntity> userEntityList = new ArrayList<>();
    for (UserRequestDto requestDto : requestDtoList) {
      userEntityList.add(requestDtoToEntity(requestDto));
    }
    return userEntityList;
  }

  public UserResponseDto entityToResponseDto(UserEntity responseDto) {
    return UserResponseDto.builder()
            .id(responseDto.getId())
            .firstName(responseDto.getFirstName())
            .lastName(responseDto.getLastName())
            .age(responseDto.getAge())
            .build();
  }
}
