package com.redis.rabbit.page.rabbituser.controller;

import com.redis.rabbit.page.rabbituser.dto.UserRequestDto;
import com.redis.rabbit.page.rabbituser.dto.UserResponseDto;
import com.redis.rabbit.page.rabbituser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/add")
  public void addUser(@RequestBody UserRequestDto requestDto) {
    userService.addUser(requestDto);
  }

  @GetMapping("/get")
  public List<UserResponseDto> getUser() {
    return userService.getUser();
  }
}
