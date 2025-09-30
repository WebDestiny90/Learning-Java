package com.spec.pageandspecification.service;

import com.spec.pageandspecification.dao.entity.CarEntity;
import com.spec.pageandspecification.dao.repository.CarRepository;
import com.spec.pageandspecification.dto.CarFilterRequest;
import com.spec.pageandspecification.dto.CarRequestDto;
import com.spec.pageandspecification.dto.CarResponseDto;
import com.spec.pageandspecification.mapper.CarMapper;
import com.spec.pageandspecification.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public void addCar(CarRequestDto requestDto){
    carRepository.save(carMapper.toDto(requestDto));
  }

  public Page<CarResponseDto> getCar(CarFilterRequest filterRequest) {
    Pageable pageable = PageRequest.of(filterRequest.getPage(), filterRequest.getSize());

    Specification<CarEntity> cars = Specification.allOf(
            CarSpecification.hasMark(filterRequest.getMark()),
            CarSpecification.hasModel(filterRequest.getModel()),
            CarSpecification.hasYear(filterRequest.getYear()),
            CarSpecification.hasFuel(filterRequest.getFuelType())
    );

    Page<CarEntity> car = carRepository.findAll(cars, pageable);
    return car.map(carMapper::toResponseDto);
  }

}
