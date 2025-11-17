package com.comebackpraktika.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComebackResponseDto {
  String firstName;
  String SurName;
  Double balance;
  Integer balanceId;
}
