package com.post.postrequest.dao.repository;

import com.post.postrequest.OsEnum;
import com.post.postrequest.dao.entity.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<MobileEntity, Long> {
  List<MobileEntity> findByEsimSupportIsTrue();

}

