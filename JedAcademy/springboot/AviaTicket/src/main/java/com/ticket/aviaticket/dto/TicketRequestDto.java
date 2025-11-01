package com.ticket.aviaticket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketRequestDto {
  String ticketId;
  String title;
  Integer count;
  Double price;
  List<Long> customerIds;
}
