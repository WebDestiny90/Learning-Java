package com.redis.specification.page.redisspecificationpage.dto;

import com.redis.specification.page.redisspecificationpage.util.FuelEnum;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarRequestDto {
  @NotBlank(message = "Mark must not be blank")
  @Size(min = 3, max = 100, message = "Mark length must be between 3 and 100 characters")
  String mark;
  @NotBlank(message = "Model must not be blank")
  @Size(min = 3, max = 100, message = "Model length must be between 3 and 100 characters")
  String model;
  @NotNull(message = "Price must not be blank")
  @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
  Double price;
  @NotNull
  @Min(value = 1000, message = "Year must be at least 1000")
  @Max(value = 9999, message = "Year must be at most 9999")
  Integer year;
  @NotNull(message = "Mark must not be blank")
  FuelEnum fuelType;
}
