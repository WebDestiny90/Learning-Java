package com.redis.car.rediscar.controller;

import com.redis.car.rediscar.dto.CarRequestDto;
import com.redis.car.rediscar.dto.CarResponseDto;
import com.redis.car.rediscar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @PostMapping("/add")
  public void addCar(@RequestBody CarRequestDto requestDto) {
    carService.addCar(requestDto);
  }

  @GetMapping("/{id}")
  public CarResponseDto getCar(@PathVariable Long id) {
    return carService.getCars(id);
  }
}
