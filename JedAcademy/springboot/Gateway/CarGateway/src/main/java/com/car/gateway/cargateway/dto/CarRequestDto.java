package com.car.gateway.cargateway.dto;

import com.car.gateway.cargateway.util.CarType;
import com.car.gateway.cargateway.util.FuelType;
import com.car.gateway.cargateway.util.TransmissionType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarRequestDto {
  String brand;
  String model;
  Integer year;
  @Enumerated(EnumType.STRING)
  FuelType fuelType;
  @Enumerated(EnumType.STRING)
  TransmissionType transmission;
  @Enumerated(EnumType.STRING)
  CarType type;
  Double price;
  Integer mileage;
  String color;
  Boolean available;
  @Column(length = 2000)
  String description;
}
