package com.post.postrequest.service;

import com.post.postrequest.dao.entity.MoviesEntity;
import com.post.postrequest.dao.repository.MoviesRepository;
import com.post.postrequest.dto.MoviesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesService {
  private final MoviesRepository moviesRepository;

  public List<MoviesEntity> getMovies() {
    return moviesRepository.findAll();
  }

  public Long addMovie(MoviesDto moviesDto) {
    var movieEntity = new MoviesEntity(moviesDto.getTitle(), moviesDto.getYear());
    moviesRepository.save(movieEntity);
    return movieEntity.getId();
  }

  public MoviesEntity updateMovie(MoviesDto moviesDto, Long id) {
    var moviesEntity = moviesRepository.findById(id).get();
    moviesEntity.setTitle(moviesDto.getTitle());
    moviesEntity.setYear(moviesDto.getYear());
    moviesRepository.save(moviesEntity);
    return moviesEntity;
  }

  public void deleteMovie(Long id) {
    moviesRepository.deleteById(id);
  }
}
