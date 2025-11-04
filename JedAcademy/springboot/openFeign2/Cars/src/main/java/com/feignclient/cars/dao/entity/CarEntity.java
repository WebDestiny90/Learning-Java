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
  @Column(nullable = false)
  Integer manufactureYear;
  @Column(nullable = false, length = 100)
  @Enumerated(EnumType.STRING)
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
  FuelType fuelType;
  Integer seats;
  Integer doors;
  Double engineVolume;
  Integer horsepower;
  Double fuelConsumption;
  Boolean airConditioner;
  Boolean gps;
  @Column(nullable = false)
  Double dailyPrice;
  @Enumerated(EnumType.STRING)
  @Column(length = 50)
  AvailabilityStatus availabilityStatus;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;
}
