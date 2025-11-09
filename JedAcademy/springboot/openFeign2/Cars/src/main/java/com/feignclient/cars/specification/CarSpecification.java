package com.feignclient.cars.specification;

import com.feignclient.cars.dao.entity.CarEntity;
import com.feignclient.cars.dto.CarFilterDto;
import com.feignclient.cars.util.*;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification {


  public static Specification<CarEntity> hasBrand(String brand) {
    return (root, query, cb) ->
            brand == null ? cb.conjunction() : cb.like(cb.lower(root.get("brand")), "%" + brand.toLowerCase() + "%");
  }

  public static Specification<CarEntity> hasModel(String model) {
    return (root, query, cb) ->
            model == null ? cb.conjunction() : cb.like(cb.lower(root.get("model")), "%" + model.toLowerCase() + "%");
  }

  public static Specification<CarEntity> hasYear(Integer manufactureYear) {
    return (root, query, cb) ->
            manufactureYear == null ? cb.conjunction() : cb.equal(root.get("manufactureYear"), manufactureYear);
  }

  public static Specification<CarEntity> hasColor(CarColor color) {
    return (root, query, cb) ->
            color == null ? cb.conjunction() : cb.equal(root.get("color"), color);
  }

  public static Specification<CarEntity> hasPlate(String plate) {
    return (root, query, cb) ->
            plate == null ? cb.conjunction() : cb.like(cb.lower(root.get(plate)), "%" + plate.toLowerCase() + "%");
  }

  public static Specification<CarEntity> hasType(CarType type) {
    return (root, query, cb) ->
            type == null ? cb.conjunction() : cb.equal(root.get("type"), type);
  }

  public static Specification<CarEntity> hasTransmission(TransmissionType transmission) {
    return (root, query, cb) ->
            transmission == null ? cb.conjunction() : cb.equal(root.get("transmission"), transmission);
  }

  public static Specification<CarEntity> hasFuel(FuelType fuel) {
    return (root, query, cb) ->
            fuel == null ? cb.conjunction() : cb.equal(root.get("fuelType"), fuel);
  }

  public static Specification<CarEntity> hasSeats(Integer seats) {
    return (root, query, cb) ->
            seats == null ? cb.conjunction() : cb.equal(root.get("seats"), seats);
  }

  public static Specification<CarEntity> hasDoors(Integer doors) {
    return (root, query, cb) ->
            doors == null ? cb.conjunction() : cb.equal(root.get("doors"), doors);
  }

  public static Specification<CarEntity> hasEngine(Double engine) {
    return (root, query, cb) ->
            engine == null ? cb.conjunction() : cb.equal(root.get("engineVolume"), engine);
  }

  public static Specification<CarEntity> hasHorse(Integer horse) {
    return (root, query, cb) ->
            horse == null ? cb.conjunction() : cb.equal(root.get("horsepower"), horse);
  }

  public static Specification<CarEntity> hasFuelConsumption(Double fuelConsumption) {
    return (root, query, cb) ->
            fuelConsumption == null ? cb.conjunction() : cb.equal(root.get("fuelConsumption"), fuelConsumption);
  }

  public static Specification<CarEntity> hasConditioner(Boolean conditioner) {
    return (root, query, cb) ->
            conditioner == null ? cb.conjunction() :
                    (conditioner ? cb.isTrue(root.get("airConditioner")) : cb.isFalse(root.get("airConditioner")));
  }

  public static Specification<CarEntity> hasGps(Boolean gps) {
    return (root, query, cb) ->
            gps == null ? cb.conjunction() : (gps ? cb.isTrue(root.get("gps")) : cb.isFalse(root.get("gps")));
  }

  public static Specification<CarEntity> hasPrice(Double price) {
    return (root, query, cb) ->
            price == null ? cb.conjunction() : cb.equal(root.get("dailyPrice"), price);
  }

  public static Specification<CarEntity> hasStatus(AvailabilityStatus status) {
    return (root, query, cb) ->
            status == null ? cb.conjunction() : cb.equal(root.get("availabilityStatus"), status);
  }

  public static Specification<CarEntity> filter(CarFilterDto filterDto) {
    return Specification.allOf(
            hasBrand(filterDto.getBrand()),
            hasModel(filterDto.getModel()),
            hasYear(filterDto.getManufactureYear()),
            hasColor(filterDto.getColor()),
            hasPlate(filterDto.getPlate()),
            hasType(filterDto.getType()),
            hasTransmission(filterDto.getTransmission()),
            hasFuel(filterDto.getFuelType()),
            hasSeats(filterDto.getSeats()),
            hasDoors(filterDto.getDoors()),
            hasEngine(filterDto.getEngineVolume()),
            hasHorse(filterDto.getHorsepower()),
            hasFuelConsumption(filterDto.getFuelConsumption()),
            hasFuel(filterDto.getFuelType()),
            hasConditioner(filterDto.getAirConditioner()),
            hasGps(filterDto.getGps()),
            hasPrice(filterDto.getDailyPrice()),
            hasStatus(filterDto.getAvailabilityStatus())
    );
  }
}
