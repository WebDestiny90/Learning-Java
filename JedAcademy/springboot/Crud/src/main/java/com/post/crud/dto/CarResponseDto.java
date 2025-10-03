package com.post.crud.dto;

import com.post.crud.util.CarColor;
import com.post.crud.util.FuelType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  String mark;
  String model;
  Integer year;
  Integer engine;
  @Enumerated(EnumType.STRING)
  CarColor color;
  @Enumerated(EnumType.STRING)
  FuelType fuelType;
}
