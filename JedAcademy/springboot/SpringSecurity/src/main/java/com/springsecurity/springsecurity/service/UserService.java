package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.dao.repository.UserRepository;
import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import com.springsecurity.springsecurity.exception.InvalidEmailException;
import com.springsecurity.springsecurity.exception.InvalidPasswordException;
import com.springsecurity.springsecurity.exception.UserNotFoundException;
import com.springsecurity.springsecurity.mapper.UserMapper;
import com.springsecurity.springsecurity.util.helper.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final BCryptPasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public Long signUp(UserRequestDto requestDto) {
    var userEntity = userRepository.findByEmail(requestDto.getEmail());

    ValidationUtil.validateUser(requestDto);

    if (userEntity.isPresent()) {
      throw new InvalidEmailException("User with this email already exists.");
    }
    var entity = userMapper.requestDtoToEntity(requestDto, passwordEncoder);
    return userRepository.save(entity).getId();
  }

  public String signIn(UserRequestDto requestDto) {
    var userEntity = userRepository.findByEmail(requestDto.getEmail())
            .orElseThrow(()-> new UserNotFoundException("User with this email does not exist"));
    if (passwordEncoder.matches(requestDto.getPassword(), userEntity.getPassword())) {
      return jwtService.generateToken(requestDto.getEmail(), userEntity.getId().toString());
    }
    throw new InvalidPasswordException("Invalid password. Please try again.");
  }

  public Long addUser(UserRequestDto requestDtoDto) {
    var addUser = userRepository.save(userMapper.toEntity(requestDtoDto));
    return addUser.getId();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }
}