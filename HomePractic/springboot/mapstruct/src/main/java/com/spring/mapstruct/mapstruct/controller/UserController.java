package com.spring.mapstruct.mapstruct.controller;

import com.spring.mapstruct.mapstruct.dto.UserResponseDto;
import com.spring.mapstruct.mapstruct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<UserResponseDto> getUser() {
    return userService.getUser();
  }

  @PostMapping
  public Long addUser(@RequestBody UserResponseDto userResponseDto){
    return userService.addUser(userResponseDto);
  }

  @DeleteMapping("/delete")
  public void deleteUserById(Long id){
    userService.deleteUserById(id);
  }
}
