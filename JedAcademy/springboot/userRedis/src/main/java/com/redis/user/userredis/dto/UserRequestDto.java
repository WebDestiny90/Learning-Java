package com.redis.user.userredis.dto;

import com.redis.user.userredis.util.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class UserRequestDto {
  @NotBlank(message = "name must be not blank!")
  String firstName;
  @NotBlank(message = "Last name must be not blank!")
  String lastName;
  @NotNull(message = "age must be not blank")
  Integer age;
  GenderEnum gender;
}
