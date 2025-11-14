package com.reservation.carreservation.controller;

import com.reservation.carreservation.dto.CarFilterDto;
import com.reservation.carreservation.dto.CarResponseDto;
import com.reservation.carreservation.dto.PageResponse;
import com.reservation.carreservation.dto.ReservationRequestDto;
import com.reservation.carreservation.dto.ReservationSuccessDto;
import com.reservation.carreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

  private final ReservationService reservationService;

  @GetMapping("/cars")
  public ResponseEntity<PageResponse<CarResponseDto>> getCars(CarFilterDto filterDto) {
    return reservationService.getAvailableCars(filterDto);
  }

  @PostMapping("/reserve")
  public ResponseEntity<ReservationSuccessDto> reserveCar(@RequestBody ReservationRequestDto requestDto) {
    var successResponse = reservationService.reserveCar(requestDto);
    return ResponseEntity.ok(successResponse);
  }
}