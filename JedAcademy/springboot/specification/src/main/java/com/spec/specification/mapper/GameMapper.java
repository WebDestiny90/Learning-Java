package com.spec.specification.mapper;

import com.spec.specification.dao.entity.GameEntity;
import com.spec.specification.dto.GameRequestDto;
import com.spec.specification.dto.GameResponseDto;
import org.springframework.stereotype.Component;


@Component
public class GameMapper {

  public GameEntity toEntity(GameRequestDto dto) {
    return GameEntity.builder()
            .title(dto.getTitle())
            .genre(dto.getGenre())
            .price(dto.getPrice())
            .releaseYear(dto.getReleaseYear())
            .build();
  }

  public GameResponseDto toResponseDto(GameEntity entity) {
    return GameResponseDto.builder()
            .title(entity.getTitle())
            .genre(entity.getGenre())
            .price(entity.getPrice())
            .releaseYear(entity.getReleaseYear())
            .build();
  }
}
