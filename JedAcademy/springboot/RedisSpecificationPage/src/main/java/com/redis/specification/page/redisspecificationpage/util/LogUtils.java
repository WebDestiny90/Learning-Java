package com.redis.specification.page.redisspecificationpage.util;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

  public static long start() {
    return System.currentTimeMillis();
  }

  public static void logDuration(String message, long start) {
    log.info("{} Duration: {} ms", message, System.currentTimeMillis() - start);
  }
}

