package com.comebackpraktika.exception;

public class MonthlyLimitExceededException extends RuntimeException {
  public MonthlyLimitExceededException(String message) {
    super(message);
  }
}
