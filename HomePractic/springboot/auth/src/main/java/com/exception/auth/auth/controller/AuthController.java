package com.exception.auth.auth.controller;

import com.exception.auth.auth.dto.AuthRequestDto;
import com.exception.auth.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/add")
  public ResponseEntity<String> addAuth(@Valid @RequestBody AuthRequestDto authRequestDto) {
    authService.addAuth(authRequestDto);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }
}
