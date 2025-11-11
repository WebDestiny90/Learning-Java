package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.dao.repository.UserRepository;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import com.springsecurity.springsecurity.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserResponseDto getProfiler(String id) {
   var profile = userRepository.findById(Long.parseLong(id))
           .orElseThrow(()-> new RuntimeException("User not found with id: " + id));
   return userMapper.entityToDto(profile);
  }
}
