package com.carstore.carstore.controller;

import com.carstore.carstore.dto.MarkRequestDto;
import com.carstore.carstore.dto.MarkResponseDto;
import com.carstore.carstore.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mark")
@RequiredArgsConstructor
public class MarkController {
  private final MarkService markService;
  @PostMapping("/add")
  public void addMark(@RequestBody MarkRequestDto markRequestDto) {
    markService.addMark(markRequestDto);
  }

  @GetMapping
  public List<MarkResponseDto> getMarks() {
    return markService.getMarks();
  }
}
