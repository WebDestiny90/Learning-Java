package com.redis.pacient.rabbitpacient.mapper;

import com.redis.pacient.rabbitpacient.dao.entity.PatientEntity;
import com.redis.pacient.rabbitpacient.dto.PatientRequestDto;
import com.redis.pacient.rabbitpacient.dto.PatientResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
  PatientEntity requestDtoToEntity(PatientRequestDto requestDto);
  List<PatientResponseDto> responseEntityToDto(List<PatientEntity> entity);
}
