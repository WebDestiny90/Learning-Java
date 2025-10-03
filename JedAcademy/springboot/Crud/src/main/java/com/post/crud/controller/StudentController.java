package com.post.crud.controller;


import com.post.crud.dto.StudentResponseDto;
import com.post.crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;

  @GetMapping
  public List<StudentResponseDto> getAllStudent() {
    return studentService.getStudents();
  }

  @GetMapping("/getstudent")
  public StudentResponseDto getStudentById(@RequestParam("id") Long id) {
    return studentService.getStudentsById(id);
  }
}
