package com.practice.openfeign.productclient.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class ProductRequestDto {
  @NotBlank(message = "Title cannot be blank!")
  String title;
  @NotNull
  @Positive
  Double price;
  @NotNull
  @Positive
  Integer stock;
}
