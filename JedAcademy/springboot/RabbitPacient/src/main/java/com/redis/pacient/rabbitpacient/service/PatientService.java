package com.redis.pacient.rabbitpacient.service;

import com.redis.pacient.rabbitpacient.dao.repository.PatientRepository;
import com.redis.pacient.rabbitpacient.dto.PatientRequestDto;
import com.redis.pacient.rabbitpacient.dto.PatientResponseDto;
import com.redis.pacient.rabbitpacient.mapper.PatientMapper;
import com.redis.pacient.rabbitpacient.service.rabbit.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository;
  private final PatientMapper patientMapper;
  private final MessageProducer messageProducer;

  public void addPatient(PatientRequestDto requestDto) {
    messageProducer.sendMessage(requestDto);
  }

  public List<PatientResponseDto> getPatient() {
    return patientMapper.responseEntityToDto(patientRepository.findAll());
  }
}
