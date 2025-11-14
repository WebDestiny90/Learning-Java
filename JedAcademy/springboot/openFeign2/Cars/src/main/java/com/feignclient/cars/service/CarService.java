package com.feignclient.cars.service;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dao.repository.CarRepository;
import com.feignclient.cars.dto.CarFilterDto;
import com.feignclient.cars.dto.CarResponseDto;
import com.feignclient.cars.dto.PageResponse;
import com.feignclient.cars.exception.CarNotAvailableException;
import com.feignclient.cars.exception.CarNotFoundException;
import com.feignclient.cars.mapper.CarMapper;
import com.feignclient.cars.specification.CarSpecification;
import com.feignclient.cars.util.AvailabilityStatus;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public PageResponse<CarResponseDto> getCars(CarFilterDto filterDto) {
    Specification<CarEntity> spec = CarSpecification.filter(filterDto);
    Page<CarEntity> pageData = carRepository.findAll(spec, PageRequest.of(filterDto.getPage(), filterDto.getSize()));
    var dtoList = carMapper.entityListToDtoList(pageData.getContent());
    return new PageResponse<>(
            dtoList,
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
    );
  }

  @Transactional
  public CarResponseDto reserveCar(Long carId) {
    var car = carRepository.findById(carId)
            .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + carId));

    if (car.getAvailabilityStatus() != AvailabilityStatus.AVAILABLE) {
      throw new CarNotAvailableException("Car is not available for reservation. Current status: " + car.getAvailabilityStatus());
    }
    
    car.setAvailabilityStatus(AvailabilityStatus.RESERVED);
    var updatedCar = carRepository.save(car);

    return carMapper.entityToDto(updatedCar);
  }

}