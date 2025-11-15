package com.reservation.carreservation.mapper;

import com.reservation.carreservation.dto.CarResponseDto;
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

        .build();
  }

//  public List<ReservationEntity> requestListDtoToEntityList(List<ReservationRequestDto> requestDtoList) {
//    List<ReservationEntity> requestList = new ArrayList<>();
//    for (ReservationRequestDto list : requestDtoList) {
//      requestList.add(requestDtoToEntityDto(list));
//    }
//    return requestList;
//  }

  public ReservationResponseDto entityToDtoResponse(ReservationEntity responseDto, CarResponseDto carResponseDto) {
    return ReservationResponseDto.builder()
        .brand(carResponseDto.getBrand())
        .model(carResponseDto.getModel())
        .manufactureYear(carResponseDto.getManufactureYear())
        .color(carResponseDto.getColor())
        .plate(carResponseDto.getPlate())
        .dailyPrice(carResponseDto.getDailyPrice())
        .startDate(responseDto.getStartDate())
        .endDate(responseDto.getEndDate())
        .status(responseDto.getStatus())
        .build();
  }

}
