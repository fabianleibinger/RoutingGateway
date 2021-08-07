package com.routing.gateway.preferenceservice.controllers.exceptions;

/**
 * Exception that is thrown if this server received an error from an upstream server.
 */
public class BadGatewayException extends RuntimeException {

    public BadGatewayException(String message) {
        super(message);
    }

    public BadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
