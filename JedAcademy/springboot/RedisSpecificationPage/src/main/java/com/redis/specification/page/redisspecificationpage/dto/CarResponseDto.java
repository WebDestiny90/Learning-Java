package com.redis.specification.page.redisspecificationpage.dto;

import com.redis.specification.page.redisspecificationpage.util.FuelEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  String mark;
  String model;
  Double price;
  Integer year;
  FuelEnum fuelType;
}
