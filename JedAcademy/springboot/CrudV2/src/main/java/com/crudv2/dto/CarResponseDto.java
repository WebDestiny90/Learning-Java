package com.crudv2.dto;

import com.crudv2.util.enums.ColorEnum;
import com.crudv2.util.enums.FuelTypeEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  Long id;
  String model;
  String brand;
  Integer year;
  Double price;
  String engine;
  ColorEnum color;
  FuelTypeEnum fuelType;
  @CreationTimestamp
  LocalDateTime createdAt;
  @UpdateTimestamp
  LocalDateTime updatedAt;
  LocalDateTime deletedAt;
}
