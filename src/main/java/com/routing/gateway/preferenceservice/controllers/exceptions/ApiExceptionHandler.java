package com.routing.gateway.preferenceservice.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/**
 * Handles API exceptions thrown by controller classes.
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {BadGatewayException.class})
    public ResponseEntity<Object> handleBadGatewayException(BadGatewayException e) {
        HttpStatus badGateway = HttpStatus.BAD_GATEWAY;
        ApiException apiException = new ApiException(badGateway, ZonedDateTime.now(), e.getMessage());
        return new ResponseEntity<>(apiException, badGateway);
    }

}
