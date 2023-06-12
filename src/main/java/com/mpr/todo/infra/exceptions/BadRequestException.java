package com.mpr.todo.infra.exceptions;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {
    super("invalid payload");
  }
}
