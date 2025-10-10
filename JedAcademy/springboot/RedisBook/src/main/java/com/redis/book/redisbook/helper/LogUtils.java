package com.redis.book.redisbook.helper;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {
  public static void logDuration(String message, long start) {
    log.info("{} Duration: {} ms", message, System.currentTimeMillis() - start);
  }
}

