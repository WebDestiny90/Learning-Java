package com.post.crud.service;

import com.post.crud.dao.entity.UserEntity;
import com.post.crud.dao.repository.UserRepository;
import com.post.crud.dto.UserResponseDto;
import com.post.crud.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<UserResponseDto> getUser() {
    List<UserEntity> entities = userRepository.findAll();
    return userMapper.entityListToDtoList(entities);
  }

  public Long addUser(UserEntity userEntity) {
    return userRepository.save(userEntity).getId();
  }

}
