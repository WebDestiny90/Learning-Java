package com.rabbit.fanout.topic.rabbtifanout.controller;

import com.rabbit.fanout.topic.rabbtifanout.dto.UserRequestDto;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserResponseDto;
import com.rabbit.fanout.topic.rabbtifanout.service.UserService;
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
