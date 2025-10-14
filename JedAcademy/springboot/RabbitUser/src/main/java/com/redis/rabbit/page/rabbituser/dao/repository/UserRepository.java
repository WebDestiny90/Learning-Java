package com.redis.rabbit.page.rabbituser.dao.repository;

import com.redis.rabbit.page.rabbituser.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
