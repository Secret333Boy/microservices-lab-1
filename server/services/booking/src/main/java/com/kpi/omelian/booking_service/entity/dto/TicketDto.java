package com.kpi.omelian.booking_service.entity.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    @NotNull
    private Double price;

    @NotNull
    private Long userId;

    @NotNull
    private Long sessionId;

    @NotNull
    private Long placeId;

}
