package com.spring.cache.springcache.dao.repository;

import com.spring.cache.springcache.dao.entity.GamerStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamerStudentRepository extends JpaRepository<GamerStudentEntity,Long> {
}
