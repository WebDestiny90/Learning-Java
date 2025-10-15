package com.redis.pacient.rabbitpacient.dto;

import com.redis.pacient.rabbitpacient.util.DiseaseEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRequestDto {
  String fullName;
  String surName;
  Integer age;
  DiseaseEnum disease;
}
