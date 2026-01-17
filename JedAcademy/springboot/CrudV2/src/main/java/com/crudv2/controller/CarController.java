package com.crudv2.controller;

import com.crudv2.dto.CarRequestDto;
import com.crudv2.dto.CarResponseDto;
import com.crudv2.dto.DeleteResponseDto;
import com.crudv2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @PostMapping("/add")
  public Long addCar(@RequestBody CarRequestDto requestDto) {
    return carService.addCar(requestDto);
  }

  @GetMapping("{id}")
  public CarResponseDto getCarById(@PathVariable("id") Long id) {
    return carService.getCarById(id);
  }

  @GetMapping("/get")
  public List<CarResponseDto> getAllCars() {
    return carService.getCars();
  }

  @PutMapping("{id}")
  public CarResponseDto updateCar(@RequestBody CarRequestDto requestDto, @PathVariable Long id) {
    return carService.updateCar(requestDto, id);
  }

  @DeleteMapping("{id}")
  public DeleteResponseDto deleteCar(@PathVariable("id") Long id) {
    return carService.deleteCar(id);
  }
}
