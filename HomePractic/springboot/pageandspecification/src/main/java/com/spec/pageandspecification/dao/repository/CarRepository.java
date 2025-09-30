package com.spec.pageandspecification.dao.repository;

import com.spec.pageandspecification.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long>, JpaSpecificationExecutor<CarEntity> {
}
