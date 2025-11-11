package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.dto.UserResponseDto;
import com.springsecurity.springsecurity.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
  private final ProfileService profileService;

  @GetMapping
  public ResponseEntity<UserResponseDto> getProfile(@RequestHeader(value = "user-id") String id) {
    return ResponseEntity.ok(profileService.getProfiler(id));
  }
}
