package com.manual.mapping.mapping.dao.entity;

import com.manual.mapping.mapping.util.CarType;
import com.manual.mapping.mapping.util.FuelType;
import com.manual.mapping.mapping.util.TransmissionType;
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
  String brand;
  String model;
  Integer year;
  @Enumerated(EnumType.STRING)
  FuelType fuelType;
  @Enumerated(EnumType.STRING)
  TransmissionType transmission;
  @Enumerated(EnumType.STRING)
  CarType type;
  Double price;
  Integer mileage;
  String color;
  Boolean available;
  @Column(length = 2000)
  String description;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;
}
