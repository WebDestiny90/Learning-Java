package com.cache.cache.mapper;

import com.cache.cache.dao.entity.TeacherEntity;
import com.cache.cache.dto.TeacherRequestDto;
import com.cache.cache.dto.TeacherResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
  TeacherEntity dtoToEntity(TeacherRequestDto teacherRequestDto);

  List<TeacherEntity> dtoToEntityList(List<TeacherRequestDto> teacherRequestDto);

  List<TeacherResponseDto> toDto(List<TeacherEntity> teacherEntities);
}