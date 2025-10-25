package com.user.gateway.usergateway.service;

import com.user.gateway.usergateway.dao.repository.UserRepository;
import com.user.gateway.usergateway.dto.UserRequestDto;
import com.user.gateway.usergateway.dto.UserResponseDto;
import com.user.gateway.usergateway.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Long addUser(UserRequestDto requestDtoDto) {
    var addUser = userRepository.save(userMapper.requestDtoToEntity(requestDtoDto));
    return addUser.getId();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }

}
