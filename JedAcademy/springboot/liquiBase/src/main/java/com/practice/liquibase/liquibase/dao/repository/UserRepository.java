package com.practice.liquibase.liquibase.dao.repository;

import com.practice.liquibase.liquibase.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
