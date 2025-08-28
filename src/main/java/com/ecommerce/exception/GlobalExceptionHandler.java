package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<String> businessException(BusinessValidationException ex) {
       return new ResponseEntity<>("Error:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
   }

}
