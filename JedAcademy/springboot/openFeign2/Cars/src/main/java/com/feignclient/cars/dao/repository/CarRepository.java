package com.feignclient.cars.dao.repository;

import com.feignclient.cars.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity> {
}
