package com.feignclient.cars.dao.entity;

import com.feignclient.cars.util.*;
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

  @Column(nullable = false, length = 100)
  String brand;

  @Column(nullable = false, length = 100)
  String model;

  @Column(name = "manufacture_year", nullable = false)
  Integer manufactureYear;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 100)
  CarColor color;

  @Column(nullable = false, length = 100, unique = true)
  String plate;

  @Enumerated(EnumType.STRING)
  @Column(length = 50)
  CarType type;

  @Enumerated(EnumType.STRING)
  @Column(length = 50)
  TransmissionType transmission;

  @Enumerated(EnumType.STRING)
  @Column(name = "fuel_type", length = 50)
  FuelType fuelType;

  Integer seats;
  Integer doors;

  @Column(name = "engine_volume")
  Double engineVolume;

  Integer horsepower;

  @Column(name = "fuel_consumption")
  Double fuelConsumption;

  @Column(name = "air_conditioner")
  Boolean airConditioner;

  Boolean gps;

  @Column(name = "daily_price", nullable = false)
  Double dailyPrice;

  @Enumerated(EnumType.STRING)
  @Column(name = "availability_status", length = 50)
  AvailabilityStatus availabilityStatus;

  String location;

  @CreationTimestamp
  @Column(name = "created_at")
  LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  LocalDateTime updatedAt;
}