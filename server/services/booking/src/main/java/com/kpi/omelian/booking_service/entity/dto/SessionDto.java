package com.kpi.omelian.booking_service.entity.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionDto {

    private Long movieId;

    private Long hallId;

    private Long cinemaId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
