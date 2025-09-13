package com.post.crud.mapper;

import com.post.crud.dao.entity.UserEntity;
import com.post.crud.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
  public UserResponseDto userEntityToDto(UserEntity entity) {
    return UserResponseDto.builder().fullName(entity.getFullName()).surName(entity.getSurName()).age(entity.getAge()).gender(entity.getGender()).build();
  }

  public List<UserResponseDto> entityListToDtoList(List<UserEntity> list) {
    List<UserResponseDto> response = new ArrayList<>();

    for (UserEntity a : list) {
      response.add(userEntityToDto(a));
    }
    return response;
  }
}
