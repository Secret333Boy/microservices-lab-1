package com.kpi.omelian.booking_service.exception;

public class NonExistedTicketError extends Exception {

    public static final String ERROR_MESSAGE = "Sorry, ticket can't be deleted.";

    public NonExistedTicketError(String message) {
        super(message);
    }

}
