package com.crud.crudpractice.service;

import com.crud.crudpractice.dao.entity.UserEntity;
import com.crud.crudpractice.dao.repository.UserRepository;
import com.crud.crudpractice.dto.DeleteResponse;
import com.crud.crudpractice.dto.UserRequestDto;
import com.crud.crudpractice.dto.UserResponseDto;
import com.crud.crudpractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Long addUser(UserRequestDto requestDto) {
    return userRepository.save(userMapper.requestDtoToEntity(requestDto)).getId();
  }

  public List<Long> addUsers(List<UserRequestDto> requestDtoList) {
    var savedUsers = userRepository.saveAll(userMapper.requestDtoListToEntityList(requestDtoList));
    return savedUsers.stream().map(UserEntity::getId).toList();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToResponseDto(userRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("User Not Found by id: "+id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userRepository.findAll().stream().map(userMapper::entityToResponseDto).toList();
  }

  public UserResponseDto updateUser(UserRequestDto requestDto, Long id) {
    var user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found by id:" + id));
    user.setFirstName(requestDto.getFirstName());
    user.setLastName(requestDto.getLastName());
    user.setAge(requestDto.getAge());
    var updated = userRepository.save(user);
    return userMapper.entityToResponseDto(updated);
  }

  public DeleteResponse deleteUser(Long id) {
    var user = userRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("user not found by id: "+ id));
    userRepository.deleteById(id);
    return DeleteResponse.builder()
            .message("User Deleted Successfully")
            .responseDto(userMapper.entityToResponseDto(user))
            .build();
  }
}
