package com.ticket.aviaticket.service;

import com.ticket.aviaticket.dao.entity.CustomerEntity;
import com.ticket.aviaticket.dao.entity.TicketEntity;
import com.ticket.aviaticket.dao.repository.CustomerRepository;
import com.ticket.aviaticket.dao.repository.TicketRepository;
import com.ticket.aviaticket.dto.TicketRequestDto;
import com.ticket.aviaticket.dto.TicketResponseDto;
import com.ticket.aviaticket.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
  private final TicketRepository ticketRepository;
  private final CustomerRepository customerRepository;
  private final TicketMapper ticketMapper;

  public void addTicket(TicketRequestDto dto) {
    List<CustomerEntity> customers = customerRepository.findAllById(dto.getCustomerIds());
    TicketEntity customer = ticketMapper.toEntity(dto, customers);
    TicketEntity saved = ticketRepository.save(customer);
    ticketMapper.toDto(saved);
  }

  public List<TicketResponseDto> getAllTickets() {
    return ticketRepository.findAll()
            .stream()
            .map(ticketMapper::toDto)
            .toList();
  }
}
