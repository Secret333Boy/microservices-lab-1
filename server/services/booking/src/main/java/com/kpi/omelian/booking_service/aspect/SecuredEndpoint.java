package com.kpi.omelian.booking_service.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.ConnectException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;


/*
* Put it on a controller-level method endpoint
* and access verification logic will be automatically
* applied for it
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Retryable(value = ConnectException.class, backoff = @Backoff(delay = 2000, maxDelay=2000))
public @interface SecuredEndpoint {
}
