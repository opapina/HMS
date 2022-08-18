package com.solvd.hms.exception;

public class InvalidListException extends RuntimeException {

    public InvalidListException(String message) {
        super(message);
    }

    public InvalidListException(String message, Throwable cause) {
        super(message, cause);
    }
}
