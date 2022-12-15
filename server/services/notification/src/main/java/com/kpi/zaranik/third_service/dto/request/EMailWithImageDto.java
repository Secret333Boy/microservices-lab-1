package com.kpi.zaranik.third_service.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EMailWithImageDto {

    @Email
    @NotNull
    private String emailTo;

    @NotNull(message = "caption of message must not be omitted")
    @Size(min = 5, message = "caption must not be less than 5 symbols")
    private String caption;

    private String messageBody;

    private byte[] image;

}
