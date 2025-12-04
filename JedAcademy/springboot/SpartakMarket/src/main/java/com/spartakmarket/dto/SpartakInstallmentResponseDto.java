package com.spartakmarket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SpartakInstallmentResponseDto {

    Long id;
    String productName;
    Double productPrice;
    LocalDateTime takenAt;
}
