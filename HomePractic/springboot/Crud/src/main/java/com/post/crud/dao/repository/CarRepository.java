package com.post.crud.dao.repository;

import com.post.crud.dao.entity.CarEntity;
import com.post.crud.dto.CarResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM car2")
  List<CarResponseDto> findCars();
}
