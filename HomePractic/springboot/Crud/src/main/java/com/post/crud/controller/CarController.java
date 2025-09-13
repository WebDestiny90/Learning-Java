package com.post.crud.controller;

import com.post.crud.dao.repository.CarRepository;
import com.post.crud.dto.CarResponseDto;
import com.post.crud.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
  final private CarService carService;
  final private CarRepository carRepository;

  @PostMapping
  private Long addCar(@RequestBody CarResponseDto carResponseDto) {
    return carService.addCar(carResponseDto);
  }

  @GetMapping
  public List<CarResponseDto> getCar() {
    return carRepository.findCars();
  }
}
