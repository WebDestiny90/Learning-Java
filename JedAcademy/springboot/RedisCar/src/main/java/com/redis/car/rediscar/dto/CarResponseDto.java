package com.redis.car.rediscar.dto;

import com.redis.car.rediscar.util.FuelEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  String mark;
  String model;
  Integer year;
  @Enumerated(EnumType.STRING)
  FuelEnum fuelType;
}
