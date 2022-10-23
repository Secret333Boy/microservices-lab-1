package com.kpi.omelian.booking_service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SessionDto {

    private Long movieId;

    private Long hallId;

    private Date startTime;

    private Date endTime;

}
