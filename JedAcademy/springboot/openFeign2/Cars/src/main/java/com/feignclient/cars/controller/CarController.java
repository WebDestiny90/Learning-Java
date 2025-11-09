package com.feignclient.cars.controller;

import com.feignclient.cars.dto.CarFilterDto;
import com.feignclient.cars.dto.CarResponseDto;
import com.feignclient.cars.dto.PageResponse;
import com.feignclient.cars.service.CarService;
import com.feignclient.cars.util.AvailabilityStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @GetMapping("{id}")
  public CarResponseDto getCarById(@PathVariable("id") Long id) {
    return carService.getCarById(id);
  }

  @GetMapping("/get")
  public ResponseEntity<PageResponse<CarResponseDto>> isCarAvailable(CarFilterDto filterDto) {
    var cars = carService.getCars(filterDto);
    return cars.content().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
  }

}
