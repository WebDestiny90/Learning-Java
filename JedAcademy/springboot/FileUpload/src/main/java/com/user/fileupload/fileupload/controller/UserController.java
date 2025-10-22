package com.user.fileupload.fileupload.controller;

import com.user.fileupload.fileupload.dto.UserRequestDto;
import com.user.fileupload.fileupload.dto.UserResponseDto;
import com.user.fileupload.fileupload.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    String savedFileName = userService.saveFileWithUuid(file);
    return savedFileName.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok("File uploaded successfully: " + savedFileName);
  }

  @PostMapping("/add")
  public Long addUser(@RequestBody UserRequestDto requestDto) {
    return userService.addUser(requestDto);
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
