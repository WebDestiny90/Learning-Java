package com.mapper.studentmapper;

import com.mapper.studentmapper.dao.entity.StudentEntity;
import com.mapper.studentmapper.dao.repository.StudentRepository;
import com.mapper.studentmapper.dto.StudentRequestDto;
import com.mapper.studentmapper.dto.StudentResponseDto;
import com.mapper.studentmapper.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  public void addStudent(List<StudentRequestDto> studentRequestDtos) {
  studentRepository.saveAll(studentMapper.dtoToEntityList(studentRequestDtos));
  }

  public List<StudentResponseDto> getStudents() {
    var students = studentRepository.findAll();
    return studentMapper.entityListToResponseDtoList(students);
  }
}
