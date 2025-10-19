package com.manual.mapping.mapping.controller;

import com.manual.mapping.mapping.Service.CarService;
import com.manual.mapping.mapping.dto.CarRequestDto;
import com.manual.mapping.mapping.dto.CarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @PostMapping("/add")
  public Long addCar(@RequestBody CarRequestDto requestDto) {
    return carService.addCar(requestDto);
  }

  @PostMapping("/addcars")
  public List<Long> addCars(@RequestBody List<CarRequestDto> requestDtoList) {
    return carService.addCarList(requestDtoList);
  }

  @PatchMapping("/{id}")
  public CarResponseDto updateCar(@RequestBody CarRequestDto updateRequestDto, @PathVariable Long id) {
    return carService.updateCar(updateRequestDto,id);
  }

  @DeleteMapping("/{id}")
  public Long deleteCar(@PathVariable Long id) {
   return carService.deleteCar(id);
  }

  @GetMapping("/{id}")
  public CarResponseDto getCarById(@PathVariable Long id) {
    return carService.getCarById(id);
  }

  @GetMapping("/getcars")
  public List<CarResponseDto> getCars() {
    return carService.getCars();
  }
}
