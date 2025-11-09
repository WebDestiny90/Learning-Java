package com.feignclient.cars.service;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dao.repository.CarRepository;
import com.feignclient.cars.dto.CarFilterDto;
import com.feignclient.cars.dto.CarResponseDto;
import com.feignclient.cars.dto.PageResponse;
import com.feignclient.cars.exception.CarNotFoundException;
import com.feignclient.cars.mapper.CarMapper;
import com.feignclient.cars.specification.CarSpecification;
import com.feignclient.cars.util.AvailabilityStatus;

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

  public CarResponseDto getCarById(Long id) {
    return carMapper.entityToDto(
            carRepository.findById(id).orElseThrow(
                    ()-> new CarNotFoundException("Car not foud with id: " + id)));
  }

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

}