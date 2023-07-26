package com.springmanja.rest.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VendorRestExceptionHandler {
    
    // Add exception handling
      /**
     * @param exc
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<VendorErrorResponse> handleException(VendorNotFoundException exc){
        // create a VendorErrorResponse
        VendorErrorResponse error = new VendorErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<VendorErrorResponse> handleException(Exception exc){
        VendorErrorResponse error = new VendorErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
