package com.springsecurity.springsecurity.controller;



import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.dto.UserResponseDto;
import com.springsecurity.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

//  @PostMapping("/add")
//  public Long addUser(@RequestBody UserRequestDto requestDto) {
//    return userService.addUser(requestDto);
//  }

  @GetMapping("/{id}")
  public UserResponseDto getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/get")
  public List<UserResponseDto> getAllUsers() {
    return userService.getAllUsers();
  }
}
