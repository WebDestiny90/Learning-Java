package com.cache.cache.controller;

import com.cache.cache.dto.TeacherRequestDto;
import com.cache.cache.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
  private final TeacherService teacherService;

  @PostMapping("/add")
  public void addTeacher(@RequestBody List<TeacherRequestDto> teacherRequestDto){
    teacherService.addTeacher(teacherRequestDto);
  }

}
