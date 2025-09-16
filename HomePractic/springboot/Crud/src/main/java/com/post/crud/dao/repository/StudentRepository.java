package com.post.crud.dao.repository;

import com.post.crud.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM student")
  List<StudentEntity> findStudents();

  @Query(nativeQuery = true, value = "SELECT * FROM student WHERE id=:id")
  Optional<StudentEntity> findStudentsById(Long id);

  List<StudentEntity> id(Long id);
}
