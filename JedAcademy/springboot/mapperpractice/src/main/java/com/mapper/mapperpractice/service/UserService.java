package com.mapper.mapperpractice.service;

import com.mapper.mapperpractice.controller.CacheController;
import com.mapper.mapperpractice.dao.entity.UserEntity;
import com.mapper.mapperpractice.dao.repository.UserRepository;
import com.mapper.mapperpractice.dto.UserRequestDto;
import com.mapper.mapperpractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final CacheController cacheController;

  public void addUser(UserRequestDto userRequestDto) {
    userRepository.save(userMapper.UserEntityToDto(userRequestDto));
    cacheController.clearCache();
  }

  public void addUsersList(List<UserRequestDto> userRequestDto) {
    userRepository.saveAll(userMapper.UserEntityListToDtoList(userRequestDto));
    cacheController.clearCache();
  }

  @Cacheable("UserList")
  public List<UserEntity> getUsers() {
    return userRepository.findAll();
  }
}
