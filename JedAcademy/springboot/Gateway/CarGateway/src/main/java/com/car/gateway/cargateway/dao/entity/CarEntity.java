package com.car.gateway.cargateway.dao.entity;

import com.car.gateway.cargateway.util.CarType;
import com.car.gateway.cargateway.util.FuelType;
import com.car.gateway.cargateway.util.TransmissionType;
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
