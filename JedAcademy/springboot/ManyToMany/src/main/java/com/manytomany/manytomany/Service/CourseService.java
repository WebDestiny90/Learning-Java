package com.manytomany.manytomany.Service;

import com.manytomany.manytomany.dao.entity.CourseEntity;
import com.manytomany.manytomany.dao.entity.StudentEntity;
import com.manytomany.manytomany.dao.repository.CourseRepository;
import com.manytomany.manytomany.dao.repository.StudentRepository;
import com.manytomany.manytomany.dto.CourseRequestDto;
import com.manytomany.manytomany.dto.CourseResponseDto;
import com.manytomany.manytomany.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentRepository studentRepository;
  private final CourseMapper courseMapper;

  public void addCourse(CourseRequestDto dto) {
    List<StudentEntity> students = studentRepository.findAllById(dto.getStudentIds());
    CourseEntity course = courseMapper.requestToEntity(dto, students);
    CourseEntity saved = courseRepository.save(course);
    courseMapper.toResponse(saved);
  }

  public List<CourseResponseDto> getAllCourses() {
    return courseRepository.findAll()
            .stream()
            .map(courseMapper::toResponse)
            .toList();
  }

  public CourseResponseDto getCourseById(Long id) {
    return courseRepository.findById(id)
            .map(courseMapper::toResponse)
            .orElseThrow(() -> new RuntimeException("Course not found"));
  }
}
