package com.mapper.mapperpractice.controller;

import com.mapper.mapperpractice.dto.UserRequestDto;
import com.mapper.mapperpractice.dto.UserResponseDto;
import com.mapper.mapperpractice.mapper.UserMapper;
import com.mapper.mapperpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @PostMapping("/add")
  public void addUser(@RequestBody UserRequestDto userRequestDto) {
    userService.addUser(userRequestDto);
  }

  @PostMapping("/addUsers")
  public void addUsers(@RequestBody List<UserRequestDto> userRequestDtoList) {
    userService.addUsersList(userRequestDtoList);
  }

  @GetMapping("/getUsers")
  public List<UserResponseDto> getUsers() {
    return userMapper.userResponseDtoList(userService.getUsers());
  }
}
