package com.spartakmarket.dao.repository;

import com.spartakmarket.dao.entity.SpartakEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpartakRepository  extends JpaRepository<SpartakEntity,Long> {
}
