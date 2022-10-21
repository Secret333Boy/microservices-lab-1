package com.kpi.zaranik.third_service.dto.response;

import com.kpi.zaranik.third_service.exceptions.validation.Violation;
import lombok.Data;

import java.util.List;

@Data
public class ValidationExceptionResponse {

  private List<Violation> violations;

  public ValidationExceptionResponse(List<Violation> violations) {
    this.violations = violations;
  }

}
