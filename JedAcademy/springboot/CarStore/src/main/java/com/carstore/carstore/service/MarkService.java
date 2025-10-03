package com.carstore.carstore.service;

import com.carstore.carstore.dao.repository.MarksRepository;
import com.carstore.carstore.dto.MarkRequestDto;
import com.carstore.carstore.dto.MarkResponseDto;
import com.carstore.carstore.mapper.MarkaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {
  private final MarksRepository marksRepository;
  private final MarkaMapper markaMapper;

  public void addMark(MarkRequestDto markRequestDto){
    marksRepository.save(markaMapper.dtoToEntity(markRequestDto));
  }

  public List<MarkResponseDto> getMarks() {
    return markaMapper.toDto(marksRepository.findAll());
  }
}
