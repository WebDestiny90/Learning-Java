package com.springsecurity.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class Test {

  @PostMapping("/p")
  public String testPost() {
    return "Test POST";
  }

  @GetMapping("/g")
  public String testGet(@RequestHeader("email") String email, @RequestHeader("user-id") String id) {
    return email + " id: " + id;
  }
}
