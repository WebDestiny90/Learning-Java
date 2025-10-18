package com.manytomany.manytomany.controller;

import com.manytomany.manytomany.Service.StudentService;
import com.manytomany.manytomany.dto.StudentRequestDto;
import com.manytomany.manytomany.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;

  @PostMapping("/add")
  public StudentResponseDto addStudent(@RequestBody StudentRequestDto dto) {
    return studentService.save(dto);
  }

  @GetMapping("/{id}")
  public StudentResponseDto getStudentById (@PathVariable Long id) {
   return studentService.getStudentById(id);
  }

  @GetMapping("/get")
  public List<StudentResponseDto> getStudents() {
    return studentService.getAllStudents();
  }
}
