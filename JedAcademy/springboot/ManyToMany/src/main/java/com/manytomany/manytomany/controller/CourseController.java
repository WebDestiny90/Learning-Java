package com.manytomany.manytomany.controller;

import com.manytomany.manytomany.Service.CourseService;
import com.manytomany.manytomany.dto.CourseRequestDto;
import com.manytomany.manytomany.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
  private final CourseService courseService;

  @PostMapping("/add")
  public void addCourse(@RequestBody CourseRequestDto dto) {
    courseService.addCourse(dto);
  }

  @GetMapping("/{id}")
  public CourseResponseDto getCourseById(@PathVariable Long id) {
    return courseService.getCourseById(id);
  }

  @GetMapping("/get")
  public List<CourseResponseDto> getCourses() {
    return courseService.getAllCourses();
  }

}
