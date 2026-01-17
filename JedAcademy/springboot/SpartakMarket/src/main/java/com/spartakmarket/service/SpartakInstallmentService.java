package com.spartakmarket.service;

import com.spartakmarket.dto.SpartakInstallmentRequestDto;
import com.spartakmarket.dto.SpartakInstallmentResponseDto;

import java.util.List;

public interface SpartakInstallmentService {
    SpartakInstallmentResponseDto addInstallment(SpartakInstallmentRequestDto dto);
    List<SpartakInstallmentResponseDto> getAllInstallments();
}
