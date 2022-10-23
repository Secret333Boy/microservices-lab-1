package com.kpi.omelian.booking_service.dto;

import lombok.Data;

@Data
public class TicketDto {

    private Double price;

    private Long userId;

    private Long sessionId;

    private Long placeId;

}
