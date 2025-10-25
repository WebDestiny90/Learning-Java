package com.otpcode.otpcode.service;

import com.otpcode.otpcode.dao.repository.OtpAttemptRepository;
import com.otpcode.otpcode.util.OtpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpVerifyService {

  private final OtpAttemptRepository repository;
  private final OtpCacheService otpCacheService;

  public ResponseEntity<String> verifyOtp(String phoneNumber, String otp) {

    var attemptOpt = repository.findByPhoneNumber(phoneNumber);
    if (attemptOpt.isEmpty()) {
      return ResponseEntity.badRequest().body("Bu nömrə üçün OTP istənilməyib.");
    }

    var cacheOtp = otpCacheService.getOtp(phoneNumber);
    if (cacheOtp == null) {
      return ResponseEntity.badRequest().body("OTP müddəti bitib və ya tapılmadı.");
    }

    if (!cacheOtp.equals(otp)) {
      return ResponseEntity.badRequest().body("Yanlış OTP kodu.");
    }

    otpCacheService.deleteOtp(phoneNumber);
    var entity = attemptOpt.get();
    entity.setRequestCount(0);
    entity.setStatus(OtpStatus.VERIFIED);
    repository.save(entity);

    return ResponseEntity.ok("OTP doğrulandı.");
  }
}
