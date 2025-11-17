package com.comebackpraktika.dao.repository;

import com.comebackpraktika.dao.entity.ComebackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamebackRepository extends JpaRepository<ComebackEntity, Long> {
}
