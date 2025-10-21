package com.schedule.user.scheduleuser.controller;

import com.schedule.user.scheduleuser.dto.UserRequestDto;
import com.schedule.user.scheduleuser.dto.UserResponseDto;
import com.schedule.user.scheduleuser.service.UserService;
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

  @GetMapping("/get")
  public List<UserResponseDto> getUsers() {
    return userService.getUsers();
  }


}
