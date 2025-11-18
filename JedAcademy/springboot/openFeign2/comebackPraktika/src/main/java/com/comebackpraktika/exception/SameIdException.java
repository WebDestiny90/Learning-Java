package com.comebackpraktika.exception;

public class SameIdException extends RuntimeException {
  public SameIdException(String message) {
    super(message);
  }
}