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
    UserEntity user = userMapper.requestDtoToEntity(requestDto);
    user.setUserPassword(jwtService.generateToken(String.valueOf(requestDto.getUserPassword())));
    return userRepository.save(user).getId();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }

}
