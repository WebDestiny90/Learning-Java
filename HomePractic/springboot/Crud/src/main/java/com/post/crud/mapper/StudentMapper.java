package com.post.crud.mapper;

import com.post.crud.dao.entity.StudentEntity;
import com.post.crud.dto.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
  public StudentResponseDto studentEntityToDto(StudentEntity studentEntity) {
    return StudentResponseDto.builder()
            .fullName(studentEntity.getFullName())
            .surName(studentEntity.getSurName())
            .age(studentEntity.getAge())
            .build();
  }

  public StudentEntity studentDtoToEntity(StudentResponseDto studentResponseDto) {
    return StudentEntity.builder()
            .fullName(studentResponseDto.getFullName())
            .surName(studentResponseDto.getSurName())
            .age(studentResponseDto.getAge())
            .build();
  }

  public List<StudentResponseDto> studentListEntityToDto(List<StudentEntity> studentEntities) {
    List<StudentResponseDto> studentList = new ArrayList<>();

    for (StudentEntity students : studentEntities) {
      studentList.add(studentEntityToDto(students));
    }
    return studentList;
  }
}
