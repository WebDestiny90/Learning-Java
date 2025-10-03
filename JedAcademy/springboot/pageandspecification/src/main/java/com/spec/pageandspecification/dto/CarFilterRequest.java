package com.spec.pageandspecification.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarFilterRequest {
  String mark;
  String model;
  Integer year;
  String fuelType;
  Integer page=0;
  Integer size=5;
}
