package com.manytomany.manytomany.mapper;

import com.manytomany.manytomany.dao.entity.CourseEntity;
import com.manytomany.manytomany.dao.entity.StudentEntity;
import com.manytomany.manytomany.dto.CourseRequestDto;
import com.manytomany.manytomany.dto.CourseResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {
  public CourseEntity requestToEntity(CourseRequestDto requestDto, List<StudentEntity> students ) {
    CourseEntity entity = new CourseEntity();
    entity.setTitle(requestDto.getTitle());
    entity.setStudents(students);
    return entity;
  }

  public CourseResponseDto toResponse(CourseEntity responseDto) {
    CourseResponseDto courseResponseDto = new CourseResponseDto();
    courseResponseDto.setTitle(responseDto.getTitle());
    courseResponseDto.setStudentNames(responseDto.getStudents().stream().map(StudentEntity::getFullName).toList());
    return courseResponseDto;
  }
}
