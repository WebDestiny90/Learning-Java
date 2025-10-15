package com.redis.pacient.rabbitpacient.Controller;

import com.redis.pacient.rabbitpacient.dto.PatientRequestDto;
import com.redis.pacient.rabbitpacient.dto.PatientResponseDto;
import com.redis.pacient.rabbitpacient.service.PatientService;
import com.redis.pacient.rabbitpacient.service.rabbit.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;
  private final MessageProducer messageProducer;

  @PostMapping("/add")
  @ResponseStatus(HttpStatus.CREATED)
  public void addPatient(@RequestBody PatientRequestDto requestDto) {
    messageProducer.sendMessage(requestDto);
  }

  @GetMapping("/get")
  @ResponseStatus(HttpStatus.OK)
  public List<PatientResponseDto> getPatient() {
    return patientService.getPatient();
  }

}
