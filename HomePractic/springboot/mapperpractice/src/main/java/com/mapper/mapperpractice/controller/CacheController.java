package com.mapper.mapperpractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cache")
@RequiredArgsConstructor
public class CacheController {
  @CacheEvict(value = "UserList", allEntries = true)
  @DeleteMapping("/clear-cache")
  public String clearCache(){
    return "Cache cleared";
  }
}
