package kz.halykbank.testtaskhalyk.controllers;

import kz.halykbank.testtaskhalyk.entities.UserErrorResponse;
import kz.halykbank.testtaskhalyk.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exception) {
        UserErrorResponse response = new UserErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<UserErrorResponse> handleException(BindException exception) {
        UserErrorResponse response = new UserErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

