package com.cache.cache.service;

import com.cache.cache.dao.entity.TeacherEntity;
import com.cache.cache.dao.repository.TeacherRepository;
import com.cache.cache.dto.TeacherRequestDto;
import com.cache.cache.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
  private final TeacherRepository teacherRepository;
  private final TeacherMapper teacherMapper;

  public void addTeacher(List<TeacherRequestDto> teacherRequestDto) {

//    teacherRepository.saveAll(teacherMapper.dtoToEntityList(teacherRequestDto));

    List<TeacherEntity> teachers = new ArrayList<>();

    for (TeacherRequestDto dto : teacherRequestDto) {
      TeacherEntity teacher = new TeacherEntity();
      teacher.setName(dto.getName());
      teacher.setSurname(dto.getSurname());
      teacher.setEmail(dto.getEmail());
      teachers.add(teacher);
    }

    teacherRepository.saveAll(teachers);
}
}
