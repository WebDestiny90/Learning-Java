package com.ticket.aviaticket.service;

import com.ticket.aviaticket.dao.entity.CustomerEntity;
import com.ticket.aviaticket.dao.entity.TicketEntity;
import com.ticket.aviaticket.dao.repository.CustomerRepository;
import com.ticket.aviaticket.dao.repository.TicketRepository;
import com.ticket.aviaticket.dto.CustomerRequestDto;
import com.ticket.aviaticket.dto.CustomerResponseDto;
import com.ticket.aviaticket.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;
  private final TicketRepository ticketRepository;

  public CustomerResponseDto save(CustomerRequestDto requestDto) {
    List<TicketEntity> customers = ticketRepository.findAllById(requestDto.getTicketIds());
    CustomerEntity entity = customerMapper.toEntity(requestDto, customers);
    CustomerEntity savedEntity = customerRepository.save(entity);
    return customerMapper.toDto(savedEntity);
  }

  public List<CustomerResponseDto> getAllCustomers() {
    List<CustomerEntity> customers = customerRepository.findAll();
    return customers.stream().map(customerMapper::toDto).toList();
  }
}
