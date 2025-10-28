package com.springsecurity.springsecurity.service;


import com.springsecurity.springsecurity.dao.repository.UserRepository;
import com.springsecurity.springsecurity.dto.EmailValidator;
import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import com.springsecurity.springsecurity.exception.InvalidEmailException;
import com.springsecurity.springsecurity.exception.InvalidEmailProvideException;
import com.springsecurity.springsecurity.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Long signUp(UserRequestDto requestDto) {
    var userEntity = userRepository.findByEmail(requestDto.getEmail());
    if (!EmailValidator.isValidEmail(requestDto.getEmail())) {
      throw new InvalidEmailProvideException("Please provide a valid email address");
    }

    if (userEntity.isPresent()) {
      throw new InvalidEmailException("User with this email already exists.");
    }
    return userRepository.save(userMapper.requestDtoToEntity(requestDto)).getId();
  }

  public Long addUser(UserRequestDto requestDtoDto) {
    var addUser = userRepository.save(userMapper.requestDtoToEntity(requestDtoDto));
    return addUser.getId();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }

}
