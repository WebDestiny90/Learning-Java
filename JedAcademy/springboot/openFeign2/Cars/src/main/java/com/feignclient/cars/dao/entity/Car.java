package com.feignclient.cars.dao.entity;

import com.feignclient.cars.util.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String brand;

  @Column(nullable = false, length = 100)
  private String model;

  @Column(name = "manufacture_year", nullable = false)
  private Integer manufactureYear;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", length = 50)
  private CarType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "transmission", length = 50)
  private TransmissionType transmission;

  @Enumerated(EnumType.STRING)
  @Column(name = "fuel_type", length = 50)
  private FuelType fuelType;

  private Integer seats;
  private Integer doors;

  @Column(name = "engine_volume")
  private Double engineVolume;

  private Integer horsepower;

  @Column(name = "fuel_consumption")
  private Double fuelConsumption;

  @Column(name = "air_conditioner")
  private Boolean airConditioner;

  private Boolean gps;

  @Column(name = "daily_price", nullable = false)
  private Double dailyPrice;

  @Enumerated(EnumType.STRING)
  @Column(name = "availability_status", length = 50)
  private AvailabilityStatus availabilityStatus;

  private String location;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}

