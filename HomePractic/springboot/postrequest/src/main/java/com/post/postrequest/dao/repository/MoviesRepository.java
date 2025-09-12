package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MoviesEntity, Long> {
}
