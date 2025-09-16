package com.spring.mapstruct.mapstruct.service;

import com.spring.mapstruct.mapstruct.dao.entity.UserEntity;
import com.spring.mapstruct.mapstruct.dao.repository.UserRepository;
import com.spring.mapstruct.mapstruct.dto.UserResponseDto;
import com.spring.mapstruct.mapstruct.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<UserResponseDto> getUser() {
    return userMapper.entityListToDto(userRepository.getAllUsers());
  }


  public Long addUser(UserResponseDto dto) {
    UserEntity entity = userMapper.dtoToEntity(dto);

    UserEntity saved = userRepository.save(entity);

    return saved.getId();
  }

  public void deleteUserById(Long id) {
    userRepository.deleteUserById(id);
  }
}
