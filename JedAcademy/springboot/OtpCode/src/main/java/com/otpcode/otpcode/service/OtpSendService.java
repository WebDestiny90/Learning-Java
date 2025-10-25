package com.otpcode.otpcode.service;

import com.otpcode.otpcode.dao.entity.OtpAttemptEntity;
import com.otpcode.otpcode.dao.repository.OtpAttemptRepository;
import com.otpcode.otpcode.dto.SendOtpResponse;
import com.otpcode.otpcode.helper.OtpCodeGenerator;
import com.otpcode.otpcode.helper.OtpDateFormatter;
import com.otpcode.otpcode.util.OtpStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpSendService {

  private final OtpAttemptRepository repository;
  private final OtpCacheService otpCacheService;
  private final OtpCodeGenerator otpCodeGenerator;

  public SendOtpResponse sendOtp(String phoneNumber) {

    var otpAttempt = repository.findByPhoneNumber(phoneNumber)
            .orElseGet(() -> createNewAttempt(phoneNumber));


    if (otpAttempt.getStatus() == OtpStatus.BLOCKED && otpAttempt.getBlockUntil() != null
            && otpAttempt.getBlockUntil().isAfter(LocalDateTime.now())) {
      return SendOtpResponse.builder()
              .status(OtpStatus.BLOCKED)
              .blockedUntil(OtpDateFormatter.format(otpAttempt.getBlockUntil()))
              .build();
    }


    if (otpAttempt.getRequestCount() >= 5) {
      otpAttempt.setStatus(OtpStatus.BLOCKED);
      otpAttempt.setBlockUntil(LocalDateTime.now().plusMinutes(5));
      repository.save(otpAttempt);

      return SendOtpResponse.builder()
              .status(OtpStatus.BLOCKED)
              .blockedUntil(OtpDateFormatter.format(otpAttempt.getBlockUntil()))
              .build();
    }

    otpAttempt.setRequestCount(otpAttempt.getRequestCount() + 1);
    otpAttempt.setStatus(OtpStatus.WAITING);
    repository.save(otpAttempt);

    var otp = otpCodeGenerator.generate();
    otpCacheService.saveOtp(phoneNumber, otp, 90);

    log.info("OTP sent to {}: {}", phoneNumber, otp);

    return SendOtpResponse.builder()
            .status(OtpStatus.WAITING)
            .expiresAt(OtpDateFormatter.format(LocalDateTime.now().plusSeconds(90)))
            .build();
  }

  private OtpAttemptEntity createNewAttempt(String phoneNumber) {
    return repository.save(OtpAttemptEntity.builder()
            .phoneNumber(phoneNumber)
            .requestCount(0)
            .status(OtpStatus.WAITING)
            .build());
  }
}
