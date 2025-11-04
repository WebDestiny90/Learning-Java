package com.feignclient.cars.dto;

import com.feignclient.cars.util.AvailabilityStatus;
import com.feignclient.cars.util.CarType;
import com.feignclient.cars.util.FuelType;
import com.feignclient.cars.util.TransmissionType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  String brand;
  String model;
  Integer manufactureYear;
  String color;
  String plate;
  CarType type;
  TransmissionType transmission;
  FuelType fuelType;
  Integer seats;
  Integer doors;
  Double engineVolume;
  Integer horsepower;
  Double fuelConsumption;
  Boolean airConditioner;
  Boolean gps;
  Double dailyPrice;
  AvailabilityStatus availabilityStatus;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;
}
