package com.mapper.studentmapper.mapper;

import com.mapper.studentmapper.dao.entity.StudentEntity;
import com.mapper.studentmapper.dto.StudentRequestDto;
import com.mapper.studentmapper.dto.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
  public List<StudentEntity> dtoToEntityList(List<StudentRequestDto> studentRequestDto){
    List<StudentEntity> studentEntityList = new ArrayList<>();
    for (StudentRequestDto requestDto : studentRequestDto) {

      studentEntityList.add(dtoToEntity(requestDto));
    }
    return studentEntityList;
 }

  public StudentEntity dtoToEntity(StudentRequestDto requestDto) {
    return StudentEntity.builder()
            .surName(requestDto.getSurName())
            .fullName(requestDto.getFullName())
            .age(requestDto.getAge())
            .studentPassword(requestDto.getStudentPassword())
            .build();
  }

  public StudentResponseDto entityToResponseDto(StudentEntity studentEntity){
    return StudentResponseDto.builder()
            .fullName(studentEntity.getFullName())
            .surName(studentEntity.getSurName())
            .age(studentEntity.getAge())
            .registeredAt(studentEntity.getRegisteredAt())
            .build();
  }

  public List<StudentResponseDto> entityListToResponseDtoList(List<StudentEntity> studentEntityList) {
    List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();

    for (StudentEntity studentEntity : studentEntityList){
      studentResponseDtoList.add(entityToResponseDto(studentEntity));
    }
    return studentResponseDtoList;
  }

}
