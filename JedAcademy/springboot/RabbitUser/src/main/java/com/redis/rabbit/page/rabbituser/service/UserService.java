package com.redis.rabbit.page.rabbituser.service;

import com.redis.rabbit.page.rabbituser.dao.repository.UserRepository;
import com.redis.rabbit.page.rabbituser.dto.UserRequestDto;
import com.redis.rabbit.page.rabbituser.dto.UserResponseDto;
import com.redis.rabbit.page.rabbituser.mapper.UserMapper;
import com.redis.rabbit.page.rabbituser.service.rabbit.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final MessageProducer messageProducer;

  public void addUser(UserRequestDto requestDto) {
    messageProducer.sendMessage(requestDto);
  }

  public List<UserResponseDto> getUser() {
    return userMapper.responseEntityListToDtoList(userRepository.findAll());
  }
}
