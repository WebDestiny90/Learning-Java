package com.post.postrequest.controller;

import com.post.postrequest.dao.entity.CarEntity;
import com.post.postrequest.dto.CarDto;
import com.post.postrequest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @GetMapping
  public List<CarEntity> getCars() {
    return carService.getCars();
  }

  @PostMapping
  public Long addCar(@RequestBody CarDto carDto) {
    return carService.addCar(carDto);
  }

  @PatchMapping("/{id}")
  public CarEntity updateCar(@RequestBody CarDto carDto, @PathVariable("id") Long id) {
    return carService.updateCar(carDto, id);
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable("id") Long id) {
    carService.deleteCar(id);
  }
}
