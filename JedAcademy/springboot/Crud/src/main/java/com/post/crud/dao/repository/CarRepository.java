package com.post.crud.dao.repository;

import com.post.crud.dao.entity.CarEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM car_list WHERE id=:id")
  Optional<CarEntity> findCars(Long id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM car_list WHERE id=:id")
  void deleteCar(Long id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE car_list SET mark=:mark, model=:model WHERE id=:id")
  void updateCarMark(String mark, String model, Long id);
}
