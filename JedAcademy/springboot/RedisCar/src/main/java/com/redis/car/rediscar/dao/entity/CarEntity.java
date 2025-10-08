package com.redis.car.rediscar.dao.entity;

import com.redis.car.rediscar.util.FuelEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
  String mark;
  String model;
  Integer year;
  @Enumerated(EnumType.STRING)
  FuelEnum fuelType;
}
