package com.traini8.backend_traini8.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)// 400 Bad Request
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400 Bad Request
    public Map<String, Object> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", "Validation failed");
        response.put("error", e.getMessage());
        return response;
    }
    @ExceptionHandler(Exception.class) // 500 Internal Server Error
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 Internal Server Error
    public Map<String, String> handleGeneralException(Exception e) {
        return Map.of("error", "An unexpected error occurred: " + e.getMessage());
    }
}
