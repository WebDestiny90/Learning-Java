package com.post.postrequest.dao.repository;

import com.post.postrequest.dao.entity.CategoryEntity;
import com.post.postrequest.dto.CategoryDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
  @Query(nativeQuery = true, value = "SELECT c.category_name, n.title, n.description FROM category_entity as c JOIN news_entity as n ON n.category_id=c.id WHERE c.id=:id")
  List<CategoryDto> findForDestiny(Long id);

  @Query(nativeQuery = true, value = "SELECT * FROM category_entity where id=:id")
  Optional<CategoryEntity> findSomeCategory(Long id);

  @Query(nativeQuery = true, value = "UPDATE category_entity SET category_name = :name WHERE id =:id")
  @Modifying
  @Transactional
  void updateSomeCategory(String name, Long id);
}
