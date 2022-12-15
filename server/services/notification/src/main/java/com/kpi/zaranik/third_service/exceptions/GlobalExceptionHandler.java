package com.kpi.zaranik.third_service.exceptions;

import com.kpi.zaranik.third_service.dto.response.ExceptionResponseEntity;
import com.kpi.zaranik.third_service.dto.response.ValidationExceptionResponse;
import com.kpi.zaranik.third_service.exceptions.validation.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ValidationExceptionResponse methodArgumentNotValidExceptionHandle(BindException exception) {
    List<Violation> violations = exception.getAllErrors().stream()
        .map(objectError -> {
          String fieldName = ((FieldError) objectError).getField();
          String defaultMessage = objectError.getDefaultMessage();
          return new Violation(fieldName, defaultMessage);
        }).toList();
    return new ValidationExceptionResponse(violations);
  }

  @ExceptionHandler(MailSendingFailedException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponseEntity mailSendingFailedException() {
    return new ExceptionResponseEntity("sending e-mail failed for some reason, try later");
  }

}
