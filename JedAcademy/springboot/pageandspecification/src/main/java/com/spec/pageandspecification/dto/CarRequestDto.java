package com.spec.pageandspecification.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarRequestDto {
  String mark;
  String model;
  Integer year;
  String fuelType;
}
