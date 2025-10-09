package com.redis.user.userredis.controller;

import com.redis.user.userredis.dto.UserRequestDto;
import com.redis.user.userredis.dto.UserResponseDto;
import com.redis.user.userredis.exception.InvalidAgeException;
import com.redis.user.userredis.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/add")
  public void addUser(@Valid @RequestBody UserRequestDto requestDto) {
    userService.addUser(requestDto);
  }

  @PostMapping("addList")
  public void addUsers(@RequestBody List<UserRequestDto> requestDtoList) {
    userService.addUsers(requestDtoList);
  }

  @GetMapping("/{id}")
  public UserResponseDto getUser(@PathVariable Long id) {
    return userService.getUsers(id);
  }

  @GetMapping("/getUsers")
  public List<UserResponseDto> getUsers() {
    return userService.getUsers();
  }
}






