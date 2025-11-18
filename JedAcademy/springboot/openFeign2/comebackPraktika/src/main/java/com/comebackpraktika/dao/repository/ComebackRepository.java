package com.comebackpraktika.dao.repository;

import com.comebackpraktika.dao.entity.ComebackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComebackRepository extends JpaRepository<ComebackEntity, Long> {
  List<ComebackEntity> findAllByDeletedFalse();
  Optional<ComebackEntity> findByIdAndDeletedFalse(Long id);
}
