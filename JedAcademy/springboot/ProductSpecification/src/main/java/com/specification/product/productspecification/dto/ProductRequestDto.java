package com.specification.product.productspecification.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
  @NotBlank(message = "Title must not be blank")
  @Size(min = 3, max = 100, message = "Title length must be between 3 and 100 characters")
  String title;

  @NotBlank(message = "Description must not be blank")
  @Size(min = 10, max = 1000, message = "Description length must be between 10 and 1000 characters")
  String description;

  @NotNull(message = "Price must not be null")
  @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
  BigDecimal price;

  @NotNull(message = "Stock must not be null")
  @Min(value = 0, message = "Stock cannot be negative")
  Integer stock;

  @NotBlank(message = "Brand must not be blank")
  @Size(min = 2, max = 50, message = "Brand length must be between 2 and 50 characters")
  String brand;

  @NotBlank(message = "Category must not be blank")
  @Size(min = 2, max = 50, message = "Category length must be between 2 and 50 characters")
  String category;

  @PastOrPresent(message = "Created date cannot be in the future")
  LocalDateTime createdAt;

  @NotNull(message = "Active status must not be null")
  Boolean active;

  @NotNull(message = "Rating must not be null")
  @DecimalMin(value = "0.0", message = "Rating must be at least 0")
  @DecimalMax(value = "5.0", message = "Rating cannot be more than 5")
  Double rating;
}
