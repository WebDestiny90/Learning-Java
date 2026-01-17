package com.spartakmarket.dao.repository;

import com.spartakmarket.dao.entity.SpartakInstallmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpartakInstallmentRepository extends JpaRepository<SpartakInstallmentEntity, Long> {
}
