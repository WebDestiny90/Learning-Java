package com.redis.pacient.rabbitpacient.dao.repository;

import com.redis.pacient.rabbitpacient.dao.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
