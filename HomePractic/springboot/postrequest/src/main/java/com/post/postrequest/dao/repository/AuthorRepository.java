package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
  List<AuthorEntity> findAllByUpdatedAt(LocalDateTime updatedAt);
}
