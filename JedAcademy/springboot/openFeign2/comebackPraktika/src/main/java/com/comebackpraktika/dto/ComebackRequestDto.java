package com.comebackpraktika.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComebackRequestDto {
  String firstName;
  String SurName;
  Double balance;
  Integer balanceId;
}
