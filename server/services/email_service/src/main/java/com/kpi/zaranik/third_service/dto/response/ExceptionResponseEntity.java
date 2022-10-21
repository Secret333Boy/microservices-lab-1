package com.kpi.zaranik.third_service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static com.kpi.zaranik.third_service.Constants.SwaggerDescriptions.ERROR_CAUSED_TIME;
import static com.kpi.zaranik.third_service.Constants.SwaggerDescriptions.ERROR_MESSAGE;


@Data
public final class ExceptionResponseEntity {

  @Schema(description = ERROR_MESSAGE)
  private final String message;

  @Schema(description = ERROR_CAUSED_TIME)
  private final LocalDateTime exceptionCauseTime;

  public ExceptionResponseEntity(String message) {
    this.message = message;
    this.exceptionCauseTime = LocalDateTime.now();
  }
}
