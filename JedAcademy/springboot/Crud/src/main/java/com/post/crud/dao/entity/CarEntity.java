package com.post.crud.dao.entity;


import com.post.crud.util.CarColor;
import com.post.crud.util.FuelType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "car_list")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String mark;
  String model;
  Integer year;
  Integer engine;
  @Enumerated(EnumType.STRING)
  CarColor color;
  @Enumerated(EnumType.STRING)
  FuelType fuelType;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;
}

