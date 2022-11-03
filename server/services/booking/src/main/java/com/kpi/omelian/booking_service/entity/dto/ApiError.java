package com.kpi.omelian.booking_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private String message;

    private LocalDateTime errorCaused;

    public static ApiError justCaused(String message){
        return new ApiError(message, LocalDateTime.now());
    }
}
