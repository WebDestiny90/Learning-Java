package com.spring.mapstruct.mapstruct.dao.repository;

import com.spring.mapstruct.mapstruct.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM customer where id=:id")
  Optional<CustomerEntity> findCustomer(Long id);
}
