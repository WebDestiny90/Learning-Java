package com.spring.cache.springcache.service;

import com.spring.cache.springcache.dao.entity.GamerStudentEntity;
import com.spring.cache.springcache.dao.repository.GamerStudentRepository;
import com.spring.cache.springcache.dto.GamerStudentRequestDto;
import com.spring.cache.springcache.dto.GamerStudentResponseDto;
import com.spring.cache.springcache.mapper.GamerStudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamerStudentService {
  private final GamerStudentRepository gamerStudentRepository;
  private final GamerStudentMapper gamerStudentMapper;

  public void addStudent(GamerStudentRequestDto gamerStudentRequestDto) {
    var entity = GamerStudentEntity.builder()
            .name(gamerStudentRequestDto.getName())
            .surname(gamerStudentRequestDto.getSurname())
            .age(gamerStudentRequestDto.getAge())
            .cityCode(gamerStudentRequestDto.getCityCode())
            .build();
    gamerStudentRepository.save(entity);
  }


  public List<GamerStudentResponseDto> getStudent() {
    return gamerStudentMapper.toListDto(gamerStudentRepository.findAll());
  }
}
