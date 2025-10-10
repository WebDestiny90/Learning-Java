package com.redis.book.redisbook.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {
  private final RedisTemplate<String, Object> redisTemplate;

  public RedisService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void setValue(String key, Object value) {
    redisTemplate.opsForValue().set(key, value);
  }

  public void setValueS(String key, Object value, int seconds) {
    redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(seconds));
  }

  public Object getValue(String key) {
    return redisTemplate.opsForValue().get(key);
  }
}