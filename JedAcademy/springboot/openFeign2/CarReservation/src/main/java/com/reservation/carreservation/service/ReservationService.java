package com.reservation.carreservation.service;

import com.reservation.carreservation.client.CarServiceFeignClient;
import com.reservation.carreservation.dao.entity.ReservationEntity;
import com.reservation.carreservation.dao.repository.ReservationRepository;
import com.reservation.carreservation.dto.CarFilterDto;
import com.reservation.carreservation.dto.CarResponseDto;
import com.reservation.carreservation.dto.PageResponse;
import com.reservation.carreservation.dto.ReservationRequestDto;
import com.reservation.carreservation.dto.ReservationResponseDto;
import com.reservation.carreservation.dto.ReservationSuccessDto;
import com.reservation.carreservation.exception.ReservationConflictException;
import com.reservation.carreservation.mapper.ReservationMapper;
import com.reservation.carreservation.util.Status;

import feign.FeignException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

  private final CarServiceFeignClient carServiceFeignClient;
  private final ReservationRepository reservationRepository;
  private final ReservationMapper reservationMapper;

  public ResponseEntity<PageResponse<CarResponseDto>> getAvailableCars(CarFilterDto filterDto) {
    return carServiceFeignClient.getCars(filterDto);
  }


  @Transactional
  public ReservationSuccessDto reserveCar(ReservationRequestDto requestDto) {
    CarResponseDto carDetailsFromFeign;

    try {
      ResponseEntity<CarResponseDto> responseEntity = carServiceFeignClient.reserveCar(requestDto.getCarId());
      carDetailsFromFeign = responseEntity.getBody();

    } catch (FeignException ex) {
      if (ex.status() == HttpStatus.CONFLICT.value()) {
        throw new ReservationConflictException("Car is not available for reservation.");
      }
      throw ex;
    }

    if (carDetailsFromFeign == null) {
      throw new ReservationConflictException("Car details were not returned from the car service after successful reservation.");
    }

    var reservationEntity = reservationMapper.requestDtoToEntityDto(requestDto);
    reservationEntity.setStatus(Status.CONFIRMED);
    reservationEntity.setEndDate(LocalDateTime.now().plusDays(1));

    var savedReservation = reservationRepository.save(reservationEntity);

    var reservationResponse = reservationMapper.entityToDtoResponse(savedReservation, carDetailsFromFeign);

    return new ReservationSuccessDto("Car reserved successfully", reservationResponse);
  }
}