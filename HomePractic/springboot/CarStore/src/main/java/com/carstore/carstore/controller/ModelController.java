package com.carstore.carstore.controller;

import com.carstore.carstore.dto.ModelRequestDto;
import com.carstore.carstore.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/model")
@RequiredArgsConstructor
public class ModelController {
  private final ModelService modelService;
  @PostMapping("/add")
  public void addModel(@RequestBody ModelRequestDto modelRequestDto){
    modelService.addModel(modelRequestDto);
  }
}
