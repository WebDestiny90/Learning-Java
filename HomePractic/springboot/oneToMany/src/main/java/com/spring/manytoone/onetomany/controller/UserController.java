package com.spring.manytoone.onetomany.controller;

import com.spring.manytoone.onetomany.dao.entity.AddressEntity;
import com.spring.manytoone.onetomany.dao.entity.UserEntity;
import com.spring.manytoone.onetomany.dao.repository.AddressRepository;
import com.spring.manytoone.onetomany.dao.repository.UserRepository;
import com.spring.manytoone.onetomany.dto.UserResponseDto;
import com.spring.manytoone.onetomany.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
  private final UserRepository userRepository;
//  private final AddressRepository addressRepository;

  @GetMapping("/{id}")
  public UserResponseDto getUser(@PathVariable Long id) {
    var user = userRepository.findById(id).orElseThrow();
    return UserMapper.INSTANCE.toDto(user);
//    return addressRepository.findById(id).orElseThrow();
  }
}
