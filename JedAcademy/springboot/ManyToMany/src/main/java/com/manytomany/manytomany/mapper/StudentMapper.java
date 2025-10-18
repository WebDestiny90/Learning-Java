package com.manytomany.manytomany.mapper;

import com.manytomany.manytomany.dao.entity.CourseEntity;
import com.manytomany.manytomany.dao.entity.StudentEntity;
import com.manytomany.manytomany.dto.StudentRequestDto;
import com.manytomany.manytomany.dto.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapper {
  public StudentEntity requestToEntity(StudentRequestDto requestDto, List<CourseEntity> courses) {
    StudentEntity request = new StudentEntity();
    request.setFullName(requestDto.getFullName());
    request.setSurName(requestDto.getSurName());
    request.setAge(requestDto.getAge());
    request.setCourses(courses);
    return request;
  }

  public StudentResponseDto toResponse(StudentEntity entity) {
    StudentResponseDto response = new StudentResponseDto();
    response.setFullName(entity.getFullName());
    response.setSurName(entity.getSurName());
    response.setAge(entity.getAge());
    response.setCourseTitles(entity.getCourses().stream().map(CourseEntity::getTitle).toList());
    return response;
  }
}
