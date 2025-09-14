package com.post.crud.dao.repository;

import com.post.crud.dao.entity.CarEntity;
import com.post.crud.dto.CarResponseDto;
import com.post.crud.util.CarColor;
import com.post.crud.util.FuelType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM car_list")
  List<CarEntity> findCars();

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO car_list (mark, model, year, engine, color, fuel_type) " +
          "VALUES (?1,?2,?3,?4,?5,?6)")
  void insertCarReturnId(String mark, String model, Integer year, Integer engine, String color, String fuel_type);
}
