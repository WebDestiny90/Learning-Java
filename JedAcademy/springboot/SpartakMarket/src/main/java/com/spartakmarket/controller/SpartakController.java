package com.spartakmarket.controller;

import com.spartakmarket.dto.SpartakInstallmentRequestDto;
import com.spartakmarket.dto.SpartakInstallmentResponseDto;
import com.spartakmarket.dto.SpartakRequestDto;
import com.spartakmarket.dto.SpartakResponseDto;
import com.spartakmarket.service.SpartakInstallmentService;
import com.spartakmarket.service.SpartakService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SpartakController {

  private final SpartakService spartakService;

  @PostMapping
  public ResponseEntity<SpartakResponseDto> createUser(@RequestBody SpartakRequestDto dto) {
    return ResponseEntity.ok(spartakService.createUser(dto));
  }

  @GetMapping
  public ResponseEntity<List<SpartakResponseDto>> getAllUsers() {
    return ResponseEntity.ok(spartakService.getAllUsers());
  }
}


