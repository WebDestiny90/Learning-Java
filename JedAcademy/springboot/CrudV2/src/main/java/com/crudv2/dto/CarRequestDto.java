package com.crudv2.dto;

import com.crudv2.util.enums.ColorEnum;
import com.crudv2.util.enums.FuelTypeEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarRequestDto {
  String model;
  String brand;
  Integer year;
  Double price;
  String engine;
  ColorEnum color;
  FuelTypeEnum fuelType;
}
