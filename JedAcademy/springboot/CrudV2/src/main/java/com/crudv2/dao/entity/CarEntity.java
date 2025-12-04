package com.crudv2.dao.entity;

import com.crudv2.util.enums.ColorEnum;
import com.crudv2.util.enums.FuelTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cars")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String model;
  String brand;
  Integer year;
  Double price;
  String engine;
  ColorEnum color;
  FuelTypeEnum fuelType;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;
  LocalDateTime deletedAt;
}
