package com.comebackpraktika.controller;

import com.comebackpraktika.dto.ComebackRequestDto;
import com.comebackpraktika.dto.ComebackResponseDto;
import com.comebackpraktika.service.ComebackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comeback")
@RequiredArgsConstructor
public class ComebackController {
  private final ComebackService comebackService;

  @PostMapping("/add")
  public Long addUser(@RequestBody ComebackRequestDto requestDto) {
    return comebackService.addUser(requestDto);
  }

  @PostMapping("/addlist")
  public List<Long> addUsers(@RequestBody List<ComebackRequestDto> requestDtoList) {
    return comebackService.addUsers(requestDtoList);
  }

  @GetMapping("/{id}")
  public ComebackResponseDto getUserById(@PathVariable("id") Long id) {
    return comebackService.getUserById(id);
  }

  @GetMapping("/get")
  public ResponseEntity<List<ComebackResponseDto>> getAllUsers() {
    var users = comebackService.getUsers();
    return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
  }

  @PutMapping("/{id}")
  public ComebackResponseDto updateUser(@RequestBody ComebackRequestDto responseDto, @PathVariable("id") Long id) {
    return comebackService.updateUser(responseDto, id);
  }

  @DeleteMapping("{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    comebackService.deleteUser(id);
  }
}
