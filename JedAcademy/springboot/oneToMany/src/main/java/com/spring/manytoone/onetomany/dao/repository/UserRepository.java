package com.spring.manytoone.onetomany.dao.repository;

import com.spring.manytoone.onetomany.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
