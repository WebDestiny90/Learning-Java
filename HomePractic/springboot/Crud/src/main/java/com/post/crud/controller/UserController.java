package com.post.crud.controller;

import com.post.crud.dao.entity.UserEntity;
import com.post.crud.dto.UserResponseDto;
import com.post.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<UserResponseDto> getUser() {
    return userService.getUser();
  }

  @PostMapping
  public Long addUser(@RequestBody UserEntity userEntity) {
    return userService.addUser(userEntity);
  }
}
