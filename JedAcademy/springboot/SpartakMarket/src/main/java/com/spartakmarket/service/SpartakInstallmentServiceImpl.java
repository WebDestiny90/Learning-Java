package com.spartakmarket.service;

import com.spartakmarket.dao.entity.SpartakEntity;
import com.spartakmarket.dao.entity.SpartakInstallmentEntity;
import com.spartakmarket.dao.repository.SpartakInstallmentRepository;
import com.spartakmarket.dao.repository.SpartakRepository;
import com.spartakmarket.dto.SpartakInstallmentRequestDto;
import com.spartakmarket.dto.SpartakInstallmentResponseDto;
import com.spartakmarket.mapper.SpartakMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpartakInstallmentServiceImpl implements SpartakInstallmentService {

    private final SpartakInstallmentRepository installmentRepository;
    private final SpartakRepository userRepository;
    private final SpartakMapper mapper;

    @Override
    public SpartakInstallmentResponseDto addInstallment(SpartakInstallmentRequestDto dto) {

        SpartakEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SpartakInstallmentEntity installment = mapper.installmentRequestToEntity(dto);
        installment.setUser(user);

        SpartakInstallmentEntity saved = installmentRepository.save(installment);

        return mapper.installmentToDto(saved);
    }

    @Override
    public List<SpartakInstallmentResponseDto> getAllInstallments() {
        return installmentRepository.findAll()
                .stream()
                .map(mapper::installmentToDto)
                .toList();
    }
}
