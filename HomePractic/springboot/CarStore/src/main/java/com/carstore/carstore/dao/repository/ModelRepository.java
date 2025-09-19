package com.carstore.carstore.dao.repository;

import com.carstore.carstore.dao.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
