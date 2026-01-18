package com.contactform.exception;

public class InvalidEmailProvideException extends RuntimeException {
  public InvalidEmailProvideException(String message) {
    super(message);
  }
}
