package com.springmanja.rest.spring.rest;


public class VendorNotFoundException extends RuntimeException {

    public VendorNotFoundException(String message) {
        super(message);
    }

    public VendorNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public VendorNotFoundException(Throwable cause){
        super(cause);
    }
}