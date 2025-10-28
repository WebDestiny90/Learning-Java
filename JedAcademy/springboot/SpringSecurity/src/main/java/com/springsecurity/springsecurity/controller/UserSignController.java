package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sign")
@RequiredArgsConstructor
public class UserSignController {
  private final UserService userService;

  @PostMapping("/up")
  public ResponseEntity<Long> signUp(@Valid @RequestBody UserRequestDto requestDto) {
   return ResponseEntity.ok(userService.signUp(requestDto));
  }
}
