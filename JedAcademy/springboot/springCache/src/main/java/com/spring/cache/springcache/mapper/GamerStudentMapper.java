package com.spring.cache.springcache.mapper;

import com.spring.cache.springcache.dao.entity.GamerStudentEntity;
import com.spring.cache.springcache.dto.GamerStudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GamerStudentMapper {

public GamerStudentResponseDto toDto (GamerStudentEntity gamerStudentEntity){
  return GamerStudentResponseDto.builder()
          .name(gamerStudentEntity.getName())
          .surname(gamerStudentEntity.getSurname())
          .age(gamerStudentEntity.getAge())
          .cityCode(gamerStudentEntity.getCityCode())
          .build();
}

public List<GamerStudentResponseDto> toListDto(List<GamerStudentEntity> entityList){
  List<GamerStudentResponseDto> gamerStudentResponseDto = new ArrayList<>();

  for (GamerStudentEntity entity : entityList){
    gamerStudentResponseDto.add(toDto(entity));
  }
  return gamerStudentResponseDto;
}}