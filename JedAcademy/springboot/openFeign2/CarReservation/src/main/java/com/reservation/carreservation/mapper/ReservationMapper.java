package com.reservation.carreservation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.reservation.carreservation.dao.entity.ReservationEntity;
import com.reservation.carreservation.dto.ReservationRequestDto;
import com.reservation.carreservation.dto.ReservationResponseDto;

@Component
public class ReservationMapper {
 public ReservationEntity requestDtoToEntityDto(ReservationRequestDto requestDto) {
    return ReservationEntity.builder()
        .userId(requestDto.getUserId())
        .carId(requestDto.getCarId())
        .startDate(requestDto.getStartDate())
        .endDate(requestDto.getEndDate())
        .build();
  }

  public List<ReservationEntity> requestListDtoToEntityList(List<ReservationRequestDto> requestDtoList) {
    List<ReservationEntity> requestList = new ArrayList<>();
    for (ReservationRequestDto list : requestDtoList) {
      requestList.add(requestDtoToEntityDto(list));
    }
    return requestList;
  }

  public ReservationResponseDto entityToDtoResponse(ReservationEntity responseDto) {
    return ReservationResponseDto.builder()
        .userId(responseDto.getUserId())
        .carId(responseDto.getCarId())
        .startDate(responseDto.getStartDate())
        .endDate(responseDto.getEndDate())
        .status(responseDto.getStatus())
        .build();
  }

  public List<ReservationResponseDto> responseListToEntityList(List<ReservationEntity> responseDtoList) {
    List<ReservationResponseDto> responseList = new ArrayList<>();
    for (ReservationEntity response : responseDtoList) {
      responseList.add(entityToDtoResponse(response));
    }
    return responseList;
  }

}
