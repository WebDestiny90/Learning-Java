package com.schedule.user.scheduleuser.mapper;

import com.schedule.user.scheduleuser.dao.entity.UserEntity;
import com.schedule.user.scheduleuser.dto.UserRequestDto;
import com.schedule.user.scheduleuser.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

  public UserEntity requestDtoToEntity(UserRequestDto requestDto) {
    return UserEntity.builder()
            .fullName(requestDto.getFullName())
            .surName(requestDto.getSurName())
            .build();
  }

  public List<UserEntity> requestDtoListToEntityList(List<UserRequestDto> requestDtoList) {
    List<UserEntity> userAddList = new ArrayList<>();

    for (UserRequestDto usersAdd : requestDtoList){
      userAddList.add(requestDtoToEntity(usersAdd));
    }
    return userAddList;
  }

  public UserResponseDto entityToDto(UserEntity responseDto) {
    return UserResponseDto.builder()
            .fullName(responseDto.getFullName())
            .surName(responseDto.getSurName())
            .build();
  }

  public List<UserResponseDto>  entityListToDtoList(List<UserEntity> responseDtoList) {
    List<UserResponseDto> responseList = new ArrayList<>();

    for (UserEntity response : responseDtoList) {
      responseList.add(entityToDto(response));
    }
    return responseList;
  }
}
