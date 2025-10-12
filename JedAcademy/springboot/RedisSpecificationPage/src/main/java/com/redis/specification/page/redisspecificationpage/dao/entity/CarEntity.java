package com.redis.specification.page.redisspecificationpage.dao.entity;

import com.redis.specification.page.redisspecificationpage.util.FuelEnum;
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
  Double price;
  Integer year;
  @Enumerated(EnumType.STRING)
  FuelEnum fuelType;
}
