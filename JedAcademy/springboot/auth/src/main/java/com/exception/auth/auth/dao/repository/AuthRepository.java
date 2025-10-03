package com.exception.auth.auth.dao.repository;

import com.exception.auth.auth.dao.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity,Long> {
}
