package com.crudv2.dao.repository;

import com.crudv2.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
  Optional<CarEntity> findByIdAndDeletedAtIsNull(Long id);
}
