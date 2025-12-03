package com.crud.crudpractice.controller;

import com.crud.crudpractice.dto.DeleteResponse;
import com.crud.crudpractice.dto.UserRequestDto;
import com.crud.crudpractice.dto.UserResponseDto;
import com.crud.crudpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/adduser")
  public Long addUser(@RequestBody UserRequestDto requestDto) {
    return userService.addUser(requestDto);
  }

  @PostMapping("/addusers")
  public List<Long> addUsers(@RequestBody List<UserRequestDto> requestDtoList) {
    return userService.addUsers(requestDtoList);
  }

  @GetMapping("/{id}")
  public UserResponseDto getUserById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/get")
  public ResponseEntity<List<UserResponseDto>> getUsers() {
    var users = userService.getAllUsers();
    return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto requestDto, @PathVariable("id") Long id) {
    return ResponseEntity.ok(userService.updateUser(requestDto, id));
  }

  @DeleteMapping("/{id}")
  public DeleteResponse deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id);
  }
}
