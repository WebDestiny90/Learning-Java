package com.manytomany.manytomany.Service;

import com.manytomany.manytomany.dao.entity.CourseEntity;
import com.manytomany.manytomany.dao.entity.StudentEntity;
import com.manytomany.manytomany.dao.repository.CourseRepository;
import com.manytomany.manytomany.dao.repository.StudentRepository;
import com.manytomany.manytomany.dto.StudentRequestDto;
import com.manytomany.manytomany.dto.StudentResponseDto;
import com.manytomany.manytomany.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;
  private final CourseRepository courseRepository;

  public StudentResponseDto save(StudentRequestDto requestDto) {
    List<CourseEntity> courses = courseRepository.findAllById(requestDto.getCourseIds());
    StudentEntity entity = studentMapper.requestToEntity(requestDto, courses);
    StudentEntity savedEntity = studentRepository.save(entity);
    return studentMapper.toResponse(savedEntity);
  }

  public StudentResponseDto getStudentById(Long id) {
    StudentEntity student = studentRepository.findById(id).orElseThrow(
            () -> new RuntimeException("STUDENT NOT FOUND")
    );
    return studentMapper.toResponse(student);
  }

  public List<StudentResponseDto> getAllStudents() {
    List<StudentEntity> students = studentRepository.findAll();
    return students.stream().map(studentMapper::toResponse).toList();
  }

}
