package com.feignclient.cars.service;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dao.repository.CarRepository;
import com.feignclient.cars.dto.CarFilterDto;
import com.feignclient.cars.dto.CarRequestDto;
import com.feignclient.cars.dto.CarResponseDto;
import com.feignclient.cars.mapper.CarMapper;
import com.feignclient.cars.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public Long addCar(CarRequestDto requestDto) {
    return carRepository.save(carMapper.dtoToEntity(requestDto)).getId();
  }

  public List<Long> addCars(List<CarRequestDto> requestDtoList) {
    return carRepository.saveAll(carMapper.dtoListToEntityList(requestDtoList))
            .stream().map(CarEntity::getId).toList();
  }

  public CarResponseDto getCarById(Long id) {
    return carMapper.entityToDto(
            carRepository.findById(id).orElseThrow(
                    ()-> new RuntimeException("Car not foud with id: " + id)));
  }

  public List<CarResponseDto> getCars(CarFilterDto filterDto) {
    Specification<CarEntity> spec = CarSpecification.filter(filterDto);
    return carMapper.entityListToDtoList(carRepository.findAll(spec));
  }
}
