package com.spec.specification.controller;

import com.spec.specification.dto.GameFilterRequest;
import com.spec.specification.dto.GameRequestDto;
import com.spec.specification.dto.GameResponseDto;
import com.spec.specification.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/games")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;

  @PostMapping("/add")
  public void addGame(@RequestBody GameRequestDto dto) {
    gameService.addGame(dto);
  }

  @GetMapping
  public List<GameResponseDto> searchGames(GameFilterRequest filter) {
    return gameService.searchGames(
            filter.getTitle(),
            filter.getGenre(),
            filter.getMinPrice(),
            filter.getMaxPrice(),
            filter.getReleaseYear()
    );
  }
}
