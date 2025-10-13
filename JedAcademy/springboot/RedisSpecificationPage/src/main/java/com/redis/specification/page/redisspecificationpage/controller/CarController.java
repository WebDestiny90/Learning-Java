package com.redis.specification.page.redisspecificationpage.controller;

import com.redis.specification.page.redisspecificationpage.dto.CarRequestDto;
import com.redis.specification.page.redisspecificationpage.dto.CarResponseDto;
import com.redis.specification.page.redisspecificationpage.dto.PageResponse;
import com.redis.specification.page.redisspecificationpage.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {
  private final CarService carService;

  @PostMapping("/add")
  public void addCar(@Valid @RequestBody CarRequestDto requestDto) {
     carService.addCar(requestDto);
  }

  @PostMapping("/addcars")
  public List<Long> addCars(@Valid @RequestBody List<CarRequestDto> requestDtoList) {
    return carService.addCars(requestDtoList);
  }

  @GetMapping("/{id}")
  public CarResponseDto getCarById(@PathVariable Long id) {
    return carService.getCar(id);
  }

  @GetMapping("/getcars")
  public PageResponse<CarResponseDto> getCars(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "6") Integer size) {
    return carService.getCars(page, size);
  }
}
