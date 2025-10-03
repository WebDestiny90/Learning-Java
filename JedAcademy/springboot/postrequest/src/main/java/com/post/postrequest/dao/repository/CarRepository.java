package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
