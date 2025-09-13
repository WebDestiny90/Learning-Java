package com.post.crud.dao.entity;


import com.post.crud.util.CarColor;
import com.post.crud.util.FuelType;
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
@Table(name = "car2")
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

  public CarEntity(String mark, String model, Integer year, Integer engine, CarColor color, FuelType fuelType) {
    this.mark = mark;
    this.model = model;
    this.year = year;
    this.engine = engine;
    this.color = color;
    this.fuelType = fuelType;
  }
}
