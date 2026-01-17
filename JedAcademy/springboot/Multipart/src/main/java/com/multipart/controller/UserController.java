package com.multipart.controller;

import com.multipart.dto.UserRequestDto;
import com.multipart.dto.UserResponseDto;
import com.multipart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // HTTP POST sorğularını /upload endpoint-inə yönləndirir
  @PostMapping("/upload")
  public ResponseEntity<UserResponseDto> uploadFile(

          // Multipart form-data içində gələn user məlumatları  // YENİ
          @ModelAttribute UserRequestDto requestDto, // YENİ

          // Request-dən "file" adlı parametri götürür
          @RequestParam("file") MultipartFile file
  ) {

    // User + şəkil save olunur və frontend üçün DTO qaytarılır
    UserResponseDto response =
            userService.saveUserWithImage(requestDto, file); // YENİ

    return ResponseEntity.ok(response); // YENİ
  }

  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // Frontend-in şəkli oxuya bilməsi üçün endpoint  // YENİ
  @GetMapping("/files/{fileName}")
  public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
    return userService.getImage(fileName); // YENİ
  }
}