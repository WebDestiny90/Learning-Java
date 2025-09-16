package com.post.crud.service;

import com.post.crud.dao.entity.StudentEntity;
import com.post.crud.dao.repository.StudentRepository;
import com.post.crud.dto.StudentResponseDto;
import com.post.crud.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;


  public List<StudentResponseDto> getStudents(){
    return studentMapper.studentListEntityToDto(studentRepository.findStudents());
  }

  public StudentResponseDto getStudentsById(Long id) {

    var students = studentRepository.findStudentsById(id).orElse(new StudentEntity());

    return studentMapper.studentEntityToDto(students);
  }
}
