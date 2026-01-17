package com.multipart.mapper;

import com.multipart.dao.entity.UserEntity;
import com.multipart.dto.UserRequestDto;
import com.multipart.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

  // Request DTO → Entity
  UserEntity requestDtoToEntity(UserRequestDto requestDto);

  // Entity → Response DTO
  @Mapping(
          target = "imageUrl",
          expression = "java(\"/api/v1/user/files/\" + user.getImageName())"
  ) // YENİ
  UserResponseDto entityToDto(UserEntity user);

  List<UserResponseDto> entityListToDtoList(List<UserEntity> responseDtoList);
}
