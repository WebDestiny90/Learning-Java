package com.ticket.aviaticket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {
  String fullName;
  String surName;
  Integer age;
  Double balance;
  List<Long> ticketIds;
}
