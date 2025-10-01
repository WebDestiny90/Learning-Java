package com.user.page.pagination.controller;

import com.user.page.pagination.dto.UserClientFilterRequest;
import com.user.page.pagination.dto.UserClientRequestDto;
import com.user.page.pagination.dto.UserClientResponseDto;
import com.user.page.pagination.service.UserClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class UserClientController {
  private final UserClientService userClientService;

  @PostMapping("/add")
  public ResponseEntity<String> addUser(@Valid @RequestBody UserClientRequestDto userClientRequestDto) {
    userClientService.addUser(userClientRequestDto);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("User has been successfully created.");
  }

  @GetMapping("/get")
  public ResponseEntity<Page<UserClientResponseDto>> getUsers(UserClientFilterRequest filterRequest) {
    Page<UserClientResponseDto> users = userClientService.getUsers(filterRequest);

   return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
  }

}
