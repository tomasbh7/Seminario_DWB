package com.product.exception;

import org.springframework.http.HttpStatus;

public class DBAccessException extends RuntimeException {

    private HttpStatus status;

    public DBAccessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}