package com.otpcode.otpcode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class OtpCacheService {

  private final RedisTemplate<String, String> redisTemplate;
  private static final String PREFIX = "otp:";

  public void saveOtp(String phoneNumber, String otpCode, long ttlSeconds) {
    redisTemplate.opsForValue().set(PREFIX + phoneNumber, otpCode, Duration.ofSeconds(ttlSeconds));
  }

  public String getOtp(String phoneNumber) {
    return redisTemplate.opsForValue().get(PREFIX + phoneNumber);
  }

  public void deleteOtp(String phoneNumber) {
    redisTemplate.delete(PREFIX + phoneNumber);
  }

  public boolean exists(String phoneNumber) {
    return redisTemplate.hasKey(PREFIX + phoneNumber);
  }
}