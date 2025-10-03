package com.spec.specification.dao.repository;

import com.spec.specification.dao.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Long>, JpaSpecificationExecutor<GameEntity> {
}
