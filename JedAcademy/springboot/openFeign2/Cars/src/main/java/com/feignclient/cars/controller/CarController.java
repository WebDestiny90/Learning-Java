package com.feignclient.cars.controller;

import com.feignclient.cars.dto.CarResponseDto;
import com.feignclient.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @GetMapping("{id}")
  public CarResponseDto getCarById(@PathVariable("id") Long id) {
    return carService.getCarById(id);
  }

  @GetMapping("/{id}/available")
  public Boolean isCarAvailable(@PathVariable Long id) {
    var car = carRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Car not found"));
    return car.getAvailabilityStatus().equals(AvailabilityStatus.AVAILABLE);
  }

}
