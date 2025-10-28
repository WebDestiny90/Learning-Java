package com.jwt.jwtuser.service;

import com.jwt.jwtuser.dao.entity.UserEntity;
import com.jwt.jwtuser.dao.repository.UserRepository;
import com.jwt.jwtuser.dto.UserRequestDto;
import com.jwt.jwtuser.dto.UserResponseDto;
import com.jwt.jwtuser.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final JwtService jwtService;

  public Long addUser(UserRequestDto requestDto) {
    return userRepository.save(userMapper.requestDtoToEntity(requestDto)).getId();
  }

  public String nameToToken(String firstName) {
    return jwtService.generateToken(firstName);
  }

  public String decoder(String tokenKey) {
    return jwtService.valid(tokenKey);
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }

}
