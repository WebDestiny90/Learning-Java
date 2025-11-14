package com.feignclient.cars.exception;

public class CarNotAvailableException extends RuntimeException {
  public CarNotAvailableException(String message) {
    super(message);
  }
}
