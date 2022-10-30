package com.kpi.omelian.booking_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private Double price;

    private Long userId;

    private Long sessionId;

    private Long placeId;

}
