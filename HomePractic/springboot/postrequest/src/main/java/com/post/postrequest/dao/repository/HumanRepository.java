package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<HumanEntity, Long> {
}
