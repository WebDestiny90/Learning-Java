package com.spring.mapstruct.mapstruct.dao.repository;

import com.spring.mapstruct.mapstruct.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
