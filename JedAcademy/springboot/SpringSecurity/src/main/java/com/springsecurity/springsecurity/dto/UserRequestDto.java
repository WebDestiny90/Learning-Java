package com.springsecurity.springsecurity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
  Long id;
  String firstName;
  String surName;
  @Column(nullable = false)
  String email;
  @NotBlank(message = "Password field must not be empty")
  String password;
}
