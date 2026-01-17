package com.spartakmarket.mapper;

import com.spartakmarket.dao.entity.SpartakEntity;
import com.spartakmarket.dao.entity.SpartakInstallmentEntity;
import com.spartakmarket.dto.SpartakInstallmentRequestDto;
import com.spartakmarket.dto.SpartakInstallmentResponseDto;
import com.spartakmarket.dto.SpartakRequestDto;
import com.spartakmarket.dto.SpartakResponseDto;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface SpartakMapper {
  SpartakEntity requestDtoToEntity(SpartakRequestDto requestDto);
  SpartakResponseDto entityToResponseDto(SpartakEntity entity);
  SpartakInstallmentResponseDto installmentToDto(SpartakInstallmentEntity entity);
  SpartakInstallmentEntity installmentRequestToEntity(SpartakInstallmentRequestDto dto);
}