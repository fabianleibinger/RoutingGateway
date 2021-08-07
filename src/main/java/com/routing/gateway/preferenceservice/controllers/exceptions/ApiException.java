package com.routing.gateway.preferenceservice.controllers.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * Basis format of exceptions thrown by controller classes.
 */
public class ApiException {

    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
    private final String message;

    public ApiException(HttpStatus httpStatus,
                        ZonedDateTime timestamp,
                        String message) {
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
