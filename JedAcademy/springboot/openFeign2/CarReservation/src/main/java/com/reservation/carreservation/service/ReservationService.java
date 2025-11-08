package com.reservation.carreservation.service;

import com.reservation.carreservation.client.CarFeignClient;
import com.reservation.carreservation.dao.entity.ReservationEntity;
import com.reservation.carreservation.dao.repository.ReservationRepository;
import com.reservation.carreservation.dto.ReservationRequestDto;
import com.reservation.carreservation.dto.ReservationResponseDto;
import com.reservation.carreservation.mapper.ReservationMapper;
import com.reservation.carreservation.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
  private final ReservationRepository reservationRepository;
  private final ReservationMapper reservationMapper;
  private final CarFeignClient carFeignClient;

  public ReservationResponseDto createReservation(ReservationRequestDto requestDto) {
    Boolean available = carFeignClient.isCarAvailable(requestDto.getCarId());
    if (!Boolean.TRUE.equals(available)) {
      throw new RuntimeException("Car is not available for reservation");
    }
    ReservationEntity entity = reservationMapper.requestDtoToEntityDto(requestDto);
    entity.setStatus(Status.PENDING);
    ReservationEntity saved = reservationRepository.save(entity);

    return reservationMapper.entityToDtoResponse(saved);
  }

  public ReservationResponseDto confirmReservation(Long id) {
    var reservation = reservationRepository.findById(id)
            .orElseThrow(()->new RuntimeException("Reservation not found"));
    reservation.setStatus(Status.CONFIRMED);
    return reservationMapper.entityToDtoResponse(reservationRepository.save(reservation));
  }

  public void cancelReservation(Long id) {
    var reservation = reservationRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Reservation not found"));
    reservation.setStatus(Status.CANCELLED);
    reservationRepository.save(reservation);
  }
}
