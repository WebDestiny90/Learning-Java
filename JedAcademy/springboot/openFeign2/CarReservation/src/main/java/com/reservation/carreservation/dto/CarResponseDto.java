package com.reservation.carreservation.dto;

import com.reservation.carreservation.util.AvailabilityStatus;
import com.reservation.carreservation.util.CarType;
import com.reservation.carreservation.util.FuelType;
import com.reservation.carreservation.util.TransmissionType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponseDto {
  Long id;
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
