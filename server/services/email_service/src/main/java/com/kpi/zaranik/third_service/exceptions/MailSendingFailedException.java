package com.kpi.zaranik.third_service.exceptions;

public class MailSendingFailedException extends RuntimeException{

    public MailSendingFailedException(String message) {
        super(message);
    }

}
