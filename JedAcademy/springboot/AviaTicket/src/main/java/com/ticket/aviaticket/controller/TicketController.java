package com.ticket.aviaticket.controller;

import com.ticket.aviaticket.dto.TicketRequestDto;
import com.ticket.aviaticket.dto.TicketResponseDto;
import com.ticket.aviaticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @PostMapping("/addticket")
  public void addTicket(@RequestBody TicketRequestDto requestDto) {
  ticketService.addTicket(requestDto);
  }

  @GetMapping("/get")
  public List<TicketResponseDto> getTickets() {
    return ticketService.getAllTickets();
  }
}
