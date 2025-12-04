package com.spartakmarket.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SpartakResponseDto {

  String firstName;
  String fatherName;
  Integer phoneNumber;
  LocalDateTime installmentAt;

  List<SpartakInstallmentResponseDto> installments;
}
