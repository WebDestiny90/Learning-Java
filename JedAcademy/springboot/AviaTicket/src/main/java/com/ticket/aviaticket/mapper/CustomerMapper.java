package com.ticket.aviaticket.mapper;

import com.ticket.aviaticket.dao.entity.CustomerEntity;
import com.ticket.aviaticket.dao.entity.TicketEntity;
import com.ticket.aviaticket.dto.CustomerRequestDto;
import com.ticket.aviaticket.dto.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "ticketTitles", expression = "java(mapTicketTitles(responseDto.getTickets()))")
  CustomerResponseDto toDto(CustomerEntity responseDto);

  CustomerEntity toEntity(CustomerRequestDto requestDto, List<TicketEntity> tickets);

  default List<String> mapTicketTitles(List<TicketEntity> tickets) {
    if (tickets == null) return null;
    return tickets.stream()
            .map(TicketEntity::getTitle)
            .toList();
  }
}
