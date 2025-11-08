package com.reservation.carreservation.dto;

import java.time.LocalDateTime;

import com.reservation.carreservation.util.Status;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationResponsetDto {
  Long userId;
  Long carId;
  LocalDateTime startDate;
  LocalDateTime endDate;
  Status status;
}
