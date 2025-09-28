package com.mapper.mapperpractice.controller;

import com.mapper.mapperpractice.dto.UserRequestDto;
import com.mapper.mapperpractice.dto.UserResponseDto;
import com.mapper.mapperpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/addUsers")
  public void addUsers(@RequestBody List<UserRequestDto> userRequestDtoList) {
    userService.addUsersList(userRequestDtoList);
  }

  @GetMapping("/getUsers")
  public List<UserResponseDto> getUsers(List<UserResponseDto> userResponseDtoList) {
    return userService.getUsers(userResponseDtoList);
  }
}
