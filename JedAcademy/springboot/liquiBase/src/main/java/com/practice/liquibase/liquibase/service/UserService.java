package com.practice.liquibase.liquibase.service;

import com.practice.liquibase.liquibase.dao.repository.UserRepository;
import com.practice.liquibase.liquibase.dto.UserRequestDto;
import com.practice.liquibase.liquibase.dto.UserResponseDto;
import com.practice.liquibase.liquibase.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private static final String USER_PREFIX = "User: ";
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final RedisService redisService;

  public void addUser(UserRequestDto requestDto) {
    var user = userRepository.save(userMapper.requestToEntity(requestDto));
    UserResponseDto userResponseDto = userMapper.responseToDto(user);
    redisService.setValue(USER_PREFIX + user.getId(), userResponseDto);
  }

  public void addUsers(List<UserRequestDto> requestList){
   var users = userRepository.saveAll(userMapper.requestListToEntity(requestList));
   List<UserResponseDto> userResponseDtoList =userMapper.responseListToDto(users);
   redisService.setValue(USER_PREFIX, userResponseDtoList);
  }

  public UserResponseDto getUsers(Long id) {
    var redisData = redisService.getValue(USER_PREFIX + id);
    if (redisData != null) {
      log.info("Data loaded from Redis for key: {} ", id);
      return (UserResponseDto) redisData;
    }
    log.info("Loading Car from Repository (Cache Miss) for ID: {}", id);
    var entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    UserResponseDto userResponseDto = userMapper.responseToDto(entity);
    redisService.setValue(USER_PREFIX + id, userResponseDto);
    return userResponseDto;
  }

public List<UserResponseDto> getUsers() {
    var redisData = redisService.getValue(USER_PREFIX);
    if (redisData != null) {
      log.info("Data loaded from Redis");
      return (List<UserResponseDto>) redisData;
    }
    log.info("Loading Car from Repository (Cache Miss):");
    var entity = userRepository.findAll();
    List<UserResponseDto> userResponseDto = userMapper.responseListToDto(entity);
    redisService.setValue(USER_PREFIX, userResponseDto);
    return userResponseDto;
  }


}
