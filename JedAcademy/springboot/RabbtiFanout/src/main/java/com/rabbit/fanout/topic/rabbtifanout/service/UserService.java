package com.rabbit.fanout.topic.rabbtifanout.service;

import com.rabbit.fanout.topic.rabbtifanout.dao.repository.UserRepository;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserRequestDto;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserResponseDto;
import com.rabbit.fanout.topic.rabbtifanout.mapper.UserMapper;
import com.rabbit.fanout.topic.rabbtifanout.service.rabbit.MessageProducer;
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
    messageProducer.sendUserNotification(requestDto);
  }

//  public void addLog(UserRequestDto requestDto) {
//    messageProducer.sendLogNotification(requestDto);
//  }

  public List<UserResponseDto> getUser() {
    return userMapper.responseEntityListToDtoList(userRepository.findAll());
  }
}
