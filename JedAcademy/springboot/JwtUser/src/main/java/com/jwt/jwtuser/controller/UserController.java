package com.jwt.jwtuser.controller;


import com.jwt.jwtuser.dto.UserRequestDto;
import com.jwt.jwtuser.dto.UserResponseDto;
import com.jwt.jwtuser.service.JwtService;
import com.jwt.jwtuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  private final JwtService jwtService;

  @PostMapping("/add")
  public Long addUser(@RequestBody UserRequestDto requestDto) {
    return userService.addUser(requestDto);
  }

  @PostMapping("{firstName}")
  public ResponseEntity<String> jwtBuilder(@PathVariable String firstName) {
    return ResponseEntity.ok(jwtService.generateToken(firstName));
  }

  @GetMapping
  public ResponseEntity<String> jwtGet(@RequestHeader String key) {
    return ResponseEntity.ok(jwtService.valid(key));
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
