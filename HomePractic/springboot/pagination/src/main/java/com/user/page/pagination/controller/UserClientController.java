package com.user.page.pagination.controller;

import com.user.page.pagination.dao.entity.UserClientEntity;
import com.user.page.pagination.dto.UserClientRequestDto;
import com.user.page.pagination.dto.UserClientResponseDto;
import com.user.page.pagination.service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class UserClientController {
  private final UserClientService userClientService;

  @PostMapping("/add")
  public void addUser(@RequestBody UserClientRequestDto userClientRequestDto) {
    userClientService.addUser(userClientRequestDto);
  }

  @GetMapping("/get")
  public Page<UserClientResponseDto> getUsers(@RequestParam(value = "page", required = false) int page,
                                              @RequestParam(value = "size", required = false) int size,
                                              @RequestParam(required = false) String fullName,
                                              @RequestParam(required = false) String surName) {
    return userClientService.getUsers(page, size, fullName, surName);
  }
}
