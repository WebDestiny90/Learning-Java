package com.post.postrequest.controller;

import com.post.postrequest.dao.entity.MoviesEntity;
import com.post.postrequest.dto.MoviesDto;
import com.post.postrequest.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MoviesController {
  private final MoviesService moviesService;

  @GetMapping
  public List<MoviesEntity> getMovies() {
    return moviesService.getMovies();
  }

  @PostMapping
  public Long addMovie(@RequestBody MoviesDto moviesDto) {
    return moviesService.addMovie(moviesDto);
  }

  @PatchMapping("{id}")
  public MoviesEntity updateMovie(@RequestBody MoviesDto moviesDto, @PathVariable("id") Long id) {
    return moviesService.updateMovie(moviesDto, id);
  }

  @DeleteMapping("{id}")
  public void deleteMovie(@PathVariable("id") Long id) {
    moviesService.deleteMovie(id);
  }
}
