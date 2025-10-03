package com.user.page.pagination.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserClientRequestDto {
  @NotBlank(message = "Name may not be empty")
  @Size(min=3, max = 16)
  String fullName;
  @NotBlank(message = "Last name cannot be empty")
  String lastName;
  @Email(message = "Invalid email format (e.g., example@example.com)")
  @NotBlank(message = "Email is required")
  String email;
}
