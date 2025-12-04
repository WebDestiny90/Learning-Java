package com.spartakmarket.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpartakInstallmentRequestDto {
    Long userId;
    String productName;
    Double productPrice;
}
