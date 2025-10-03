package com.exception.auth.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequestDto {
  @NotBlank(message = "Username cannot be blank!")
  String userName;
  @NotBlank(message = "Email cannot be blank!")
  @Email(message = "Email format is invalid!")
  String email;
  @NotBlank(message = "Password cannot be blank!")
  String password;
}
