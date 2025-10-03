package com.post.crud.controller;

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

  @PostMapping
  private Long addCar(@RequestBody CarResponseDto carResponseDto) {
   return carService.addCar(carResponseDto);
  }

  @GetMapping("getcar/all")
  public List<CarResponseDto> getAllCars() {
    return carService.getAllCars();
  }

  @GetMapping("/getcar")
  public CarResponseDto getCar(@RequestParam("id") Long id) {
    return carService.getCars(id);
  }

  @DeleteMapping
  public void deleteCar(@RequestParam("id") Long id){
    carService.deleteCar(id);
  }

  @PutMapping("/{id}")
  public void updateCarMark(@RequestParam("mark") String mark, @RequestParam("model") String model, @PathVariable("id") Long id){
    carService.updateCarMark(mark,model, id);
  }
}