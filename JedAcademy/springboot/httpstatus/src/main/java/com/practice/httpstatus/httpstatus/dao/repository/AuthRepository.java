package com.practice.httpstatus.httpstatus.dao.repository;

import com.practice.httpstatus.httpstatus.dao.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity,Long> {
}
