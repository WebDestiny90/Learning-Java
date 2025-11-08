package com.reservation.carreservation.controller;

import com.reservation.carreservation.dto.ReservationRequestDto;
import com.reservation.carreservation.dto.ReservationResponseDto;
import com.reservation.carreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDto> create(@RequestBody ReservationRequestDto dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<ReservationResponseDto> confirm(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.confirmReservation(id));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }
}
