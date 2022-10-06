package com.kpi.omelian.booking_service.exception;

public class NonExistedSessionError extends Exception {

    public static final String ERROR_MESSAGE = "Sorry, session doesn't exist, so it can't be deleted.";

    public NonExistedSessionError(String message) {
        super(message);
    }

}
