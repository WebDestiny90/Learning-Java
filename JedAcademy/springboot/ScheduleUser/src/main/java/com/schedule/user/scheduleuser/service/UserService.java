package com.schedule.user.scheduleuser.service;

import com.schedule.user.scheduleuser.dao.repository.UserRepository;
import com.schedule.user.scheduleuser.dto.UserRequestDto;
import com.schedule.user.scheduleuser.dto.UserResponseDto;
import com.schedule.user.scheduleuser.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Long addUser(UserRequestDto requestDto){
    var user = userRepository.save(userMapper.requestDtoToEntity(requestDto));
    return user.getId();
  }

  @Scheduled(fixedRate = 10000)
  public List<UserResponseDto> getUsers() {
    var users = userMapper.entityListToDtoList(userRepository.findAll());
    users.forEach(System.out::println);
    return users;
  }
}
