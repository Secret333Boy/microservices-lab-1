package com.kpi.omelian.booking_service.exception;

public class BookingSeatNotValidException extends RuntimeException {

  public BookingSeatNotValidException() {
    super();
  }

  public BookingSeatNotValidException(String message) {
    super(message);
  }

  public BookingSeatNotValidException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookingSeatNotValidException(Throwable cause) {
    super(cause);
  }
}
