package com.kpi.zaranik.third_service.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DelayedEMailDetails {

  @Email
  @NotNull
  private String emailTo;

  @NotNull(message = "caption of message must not be omitted")
  @Size(min = 5, message = "caption must not be less than 5 symbols")
  private String caption;

  @NotNull(message = "body of message must not be omitted")
  private String messageBody;

  @NotNull
  private LocalDateTime whenToSendMillis;
}
