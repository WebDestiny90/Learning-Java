package com.mapper.studentmapper.controller;

import com.mapper.studentmapper.StudentService;
import com.mapper.studentmapper.dao.repository.StudentRepository;
import com.mapper.studentmapper.dto.StudentRequestDto;
import com.mapper.studentmapper.dto.StudentResponseDto;
import com.mapper.studentmapper.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;
  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @PostMapping("/add")
  public void addStudent(@RequestBody List<StudentRequestDto> studentRequestDtos){
    studentRepository.saveAll(studentMapper.dtoToEntityList(studentRequestDtos));
  }

  @GetMapping("/get")
  public List<StudentResponseDto> getStudents() {
    return studentService.getStudents();
  }
}
