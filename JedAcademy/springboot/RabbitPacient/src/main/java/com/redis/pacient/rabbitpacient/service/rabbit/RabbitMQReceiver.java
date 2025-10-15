package com.redis.pacient.rabbitpacient.service.rabbit;

import com.redis.pacient.rabbitpacient.dao.repository.PatientRepository;
import com.redis.pacient.rabbitpacient.dto.PatientRequestDto;
import com.redis.pacient.rabbitpacient.mapper.PatientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQReceiver {
  private final PatientRepository patientRepository;
  private final PatientMapper patientMapper;

  @RabbitListener(queues = "patient")
  public void receiveMessage(PatientRequestDto requestDto) {
    try {
      log.info("Received message {}", requestDto);
      var patientEntity = patientMapper.requestDtoToEntity(requestDto);
      var savedPatient = patientRepository.save(patientEntity);
      log.info("Patient saved successfully with ID: {}", savedPatient.getId());
    } catch (Exception e) {
      log.error("Failed to process message: {}", requestDto, e);
    }
  }
}
