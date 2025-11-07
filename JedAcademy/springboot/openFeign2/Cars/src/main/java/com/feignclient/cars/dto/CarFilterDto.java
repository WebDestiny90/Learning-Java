package com.feignclient.cars.dto;

import com.feignclient.cars.util.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarFilterDto {
  String brand;
  String model;
  Integer manufactureYear;
  CarColor color;
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

  Integer page = 0;
  Integer size = 6;
}
