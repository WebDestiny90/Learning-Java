package com.spartakmarket.controller;

import com.spartakmarket.dto.SpartakInstallmentRequestDto;
import com.spartakmarket.dto.SpartakInstallmentResponseDto;
import com.spartakmarket.service.SpartakInstallmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/installments")
@RequiredArgsConstructor
public class SpartakInstallmentController {

    private final SpartakInstallmentService installmentService;

    @PostMapping
    public ResponseEntity<SpartakInstallmentResponseDto> addInstallment(
            @RequestBody SpartakInstallmentRequestDto dto
    ) {
        return ResponseEntity.ok(installmentService.addInstallment(dto));
    }

    @GetMapping
    public ResponseEntity<List<SpartakInstallmentResponseDto>> getAllInstallments() {
        return ResponseEntity.ok(installmentService.getAllInstallments());
    }
}
