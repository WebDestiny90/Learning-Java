package com.spec.specification.service;

import com.spec.specification.dao.entity.GameEntity;
import com.spec.specification.dao.repository.GameRepository;
import com.spec.specification.dto.GameRequestDto;
import com.spec.specification.dto.GameResponseDto;
import com.spec.specification.mapper.GameMapper;
import com.spec.specification.specification.GameSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
  private final GameRepository gameRepository;
  private final GameMapper gameMapper;

  public void addGame(GameRequestDto dto) {
    GameEntity saved = gameRepository.save(gameMapper.toEntity(dto));
    gameMapper.toResponseDto(saved);
  }

  public List<GameResponseDto> searchGames(String title, String genre, Double minPrice, Double maxPrice, Integer releaseYear) {
    Specification<GameEntity> spec = Specification.allOf(
            GameSpecification.hasTitle(title),
            GameSpecification.hasGenre(genre),
            GameSpecification.priceGreaterThan(minPrice),
            GameSpecification.priceLessThan(maxPrice),
            GameSpecification.releaseYearIs(releaseYear)
    );


    return gameRepository.findAll(spec)
            .stream()
            .map(gameMapper::toResponseDto)
            .toList();
  }
}
