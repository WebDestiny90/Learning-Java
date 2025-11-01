package com.ticket.aviaticket.mapper;

import com.ticket.aviaticket.dao.entity.CustomerEntity;
import com.ticket.aviaticket.dao.entity.TicketEntity;
import com.ticket.aviaticket.dto.TicketRequestDto;
import com.ticket.aviaticket.dto.TicketResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

  @Mapping(
          target = "customerNames",
          expression = "java(mapCustomerNames(responseDto.getCustomers()))"
  )
  TicketResponseDto toDto(TicketEntity responseDto);

  default List<String> mapCustomerNames(List<CustomerEntity> customers) {
    if (customers == null) return null;
    return customers.stream()
            .map(CustomerEntity::getFullName)
            .toList();
  }

  TicketEntity toEntity(TicketRequestDto requestDto, List<CustomerEntity> customers);
}

