package com.reservation.carreservation.dto;

import java.time.LocalDateTime;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationRequestDto {
  Long userId;
  Long carId;
  LocalDateTime startDate;
  LocalDateTime endDate;
}
