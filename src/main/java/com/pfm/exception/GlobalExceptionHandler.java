package com.pfm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicate(DuplicateResourceException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", 409,
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentials(
            BadCredentialsException ex
    ) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", 401,
                        "message", "Invalid email or password"
                ));

    }
}
