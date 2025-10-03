package com.practice.httpstatus.httpstatus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class AuthRequestDto {
  @NotBlank(message = "Username cannot be blank!")
  String userName;
  @NotBlank(message = "Email cannot be blank!")
  @Email(message = "Email format is invalid!")
  String email;
  @NotBlank(message = "Username cannot be blank!")
  String password;
}
