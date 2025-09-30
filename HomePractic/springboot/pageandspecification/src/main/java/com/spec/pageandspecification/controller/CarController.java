package com.spec.pageandspecification.controller;

import com.spec.pageandspecification.dto.CarFilterRequest;
import com.spec.pageandspecification.dto.CarRequestDto;
import com.spec.pageandspecification.dto.CarResponseDto;
import com.spec.pageandspecification.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @PostMapping("/addCar")
  public void addCar(@RequestBody CarRequestDto requestDto){
    carService.addCar(requestDto);
  }

  @GetMapping("/getCar")
  public Page<CarResponseDto> getCar(CarFilterRequest filterRequest){
    return carService.getCar(filterRequest);
  }
}
