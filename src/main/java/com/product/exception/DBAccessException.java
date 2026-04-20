package com.product.exception;

import org.springframework.http.HttpStatus;

public class DBAccessException extends RuntimeException {

    private HttpStatus status;
    private static final long serialVersionUID = 1L;

    public DBAccessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    
    public DBAccessException(Exception e) {
        super(e.getMessage(), e);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getStatus() {
        return status;
    }
}