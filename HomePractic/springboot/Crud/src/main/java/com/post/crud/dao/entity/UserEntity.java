package com.post.crud.dao.entity;

import com.post.crud.util.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user2")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String fullName;
  String surName;
  Integer age;
  @Enumerated(EnumType.STRING)
  Gender gender;
  @CreationTimestamp
  LocalDateTime createdAT;
  @UpdateTimestamp
  LocalDateTime updatedAt;
}
