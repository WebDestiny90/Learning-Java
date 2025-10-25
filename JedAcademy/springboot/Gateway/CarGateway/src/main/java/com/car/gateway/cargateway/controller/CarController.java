package com.car.gateway.cargateway.controller;

import com.car.gateway.cargateway.Service.CarService;
import com.car.gateway.cargateway.dto.CarRequestDto;
import com.car.gateway.cargateway.dto.CarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public ResponseEntity<String> deleteCar(@PathVariable Long id) {
   carService.deleteCar(id);
   return ResponseEntity.status(HttpStatus.OK).body("Car with id:" + id + " deleted successfully");
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
