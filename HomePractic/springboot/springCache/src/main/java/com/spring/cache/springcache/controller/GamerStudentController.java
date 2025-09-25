package com.spring.cache.springcache.controller;

import com.spring.cache.springcache.dto.GamerStudentRequestDto;
import com.spring.cache.springcache.dto.GamerStudentResponseDto;
import com.spring.cache.springcache.service.GamerStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class GamerStudentController {
  private final GamerStudentService gamerStudentService;


  @PostMapping("/add")
  public void studentCreate(@RequestBody GamerStudentRequestDto gamerStudentRequestDto){
    gamerStudentService.addStudent(gamerStudentRequestDto);
  }

  @GetMapping("/get")
  public List<GamerStudentResponseDto> getStudent(){
    return gamerStudentService.getStudent();
  }
}
