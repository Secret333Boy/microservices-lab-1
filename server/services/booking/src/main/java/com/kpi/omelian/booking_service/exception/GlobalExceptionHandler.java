package com.kpi.omelian.booking_service.exception;

import com.kpi.omelian.booking_service.entity.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NonExistedTicketError.class, NonExistedSessionError.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError nonExistedTicketErrorHandler(NonExistedTicketError e){
        return ApiError.justCaused(e.getMessage());
    }

}
