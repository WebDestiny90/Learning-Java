package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
}
