package com.mapper.mapperpractice.service;

import com.mapper.mapperpractice.dao.repository.UserRepository;
import com.mapper.mapperpractice.dto.UserRequestDto;
import com.mapper.mapperpractice.dto.UserResponseDto;
import com.mapper.mapperpractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public void addUser(UserRequestDto userRequestDto) {
    userRepository.save(userMapper.UserEntityToDto(userRequestDto));
  }

  public void addUsersList(List<UserRequestDto> userRequestDto) {
    userRepository.saveAll(userMapper.UserEntityListToDtoList(userRequestDto));
  }

  public List<UserResponseDto> getUsers(List<UserResponseDto> userResponseDtoList) {
    var users = userRepository.findAll();
    return userMapper.userResponseDtoList(users);
  }
}
