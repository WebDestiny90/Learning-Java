package com.carstore.carstore.service;

import com.carstore.carstore.dao.entity.ModelEntity;
import com.carstore.carstore.dao.repository.MarksRepository;
import com.carstore.carstore.dao.repository.ModelRepository;
import com.carstore.carstore.dto.ModelRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
  private final ModelRepository modelRepository;
  private final MarksRepository marksRepository;

  public void addModel(ModelRequestDto modelRequestDto) {
    var marka = marksRepository.findById(modelRequestDto.getMarkId()).orElseThrow(()-> new RuntimeException("Mark not found"));
    var model = ModelEntity.builder()
            .modelName(modelRequestDto.getModelName())
            .price(modelRequestDto.getPrice())
            .marks(marka)
            .build();

    modelRepository.save(model);
    marka.setCarCount(marka.getCarCount()+1);
    marksRepository.save(marka);
  }
}
