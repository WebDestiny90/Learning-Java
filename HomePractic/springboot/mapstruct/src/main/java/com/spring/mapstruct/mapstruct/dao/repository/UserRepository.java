package com.spring.mapstruct.mapstruct.dao.repository;

import com.spring.mapstruct.mapstruct.dao.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM users")
  List<UserEntity> getAllUsers();


  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM users WHERE id=:id")
  void deleteUserById(@Param("id") Long id);
}
