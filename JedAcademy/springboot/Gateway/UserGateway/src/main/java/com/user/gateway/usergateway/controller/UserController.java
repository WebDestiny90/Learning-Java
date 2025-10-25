package com.user.gateway.usergateway.controller;


import com.user.gateway.usergateway.dto.UserRequestDto;
import com.user.gateway.usergateway.dto.UserResponseDto;
import com.user.gateway.usergateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/add")
  public Long addUser(@RequestBody UserRequestDto requestDto) {
    return userService.addUser(requestDto);
  }

  @GetMapping("/{id}")
  public UserResponseDto getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/get")
  public List<UserResponseDto> getAllUsers() {
    return userService.getAllUsers();
  }
}
