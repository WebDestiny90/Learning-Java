package com.springsecurity.springsecurity.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
  String firstName;
  String surName;
  @Column(nullable = false)
  String email;
  String password;
}
