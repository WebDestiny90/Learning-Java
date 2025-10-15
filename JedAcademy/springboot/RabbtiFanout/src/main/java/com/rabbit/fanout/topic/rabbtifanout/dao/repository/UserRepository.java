package com.rabbit.fanout.topic.rabbtifanout.dao.repository;

import com.rabbit.fanout.topic.rabbtifanout.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
