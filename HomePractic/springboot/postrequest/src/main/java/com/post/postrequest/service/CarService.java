package com.post.postrequest.service;

import com.post.postrequest.dao.entity.CarEntity;
import com.post.postrequest.dao.repository.CarRepository;
import com.post.postrequest.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
  private final CarRepository carRepository;

  public List<CarEntity> getCars() {
    return carRepository.findAll();
  }

  public Long addCar(CarDto carDto) {
    var cars = new CarEntity(carDto.getModel(), carDto.getMark(), carDto.getYear(), carDto.getEngine(), carDto.getPrice(), carDto.getColor());

    CarEntity entity = carRepository.save(cars);

    return entity.getId();
  }

  public CarEntity updateCar(CarDto carDto, Long id) {
    var carEntity = carRepository.findById(id).get();
    carEntity.setMark(carDto.getMark());
    carEntity.setModel(carDto.getMark());
    carEntity.setYear(carDto.getYear());
    carEntity.setEngine(carDto.getEngine());
    carEntity.setPrice(carDto.getPrice());
    carEntity.setColor(carDto.getColor());
    carRepository.save(carEntity);
    return carEntity;
  }

  public void deleteCar(Long id) {
    carRepository.deleteById(id);
  }
}
