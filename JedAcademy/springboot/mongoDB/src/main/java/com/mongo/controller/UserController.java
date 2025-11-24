package com.mongo.controller;

import com.mongo.dao.entity.UserEntity;
import com.mongo.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
//@RequiredArgsConstructor
public class UserController {
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @PostMapping("/add")
  public void addUser(@RequestBody UserEntity user) {
    userRepository.save(user);
  }

  @GetMapping("/get")
  public List<UserEntity> getUser() {
    return userRepository.findAll();
  }
}
