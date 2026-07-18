package com.library.api;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
