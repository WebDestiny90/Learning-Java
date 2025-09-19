package com.spring.customer.order.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String firstName;
  String surName;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;

  @OneToMany(mappedBy = "customers")
  List<OrderEntity> orderEntities;
}
