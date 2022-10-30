package com.kpi.omelian.booking_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {

    private Long movieId;

    private Long hallId;

    private Date startTime;

    private Date endTime;

}
