package com.solvd.hms.exception;

public class ExperienceInvalidException extends Exception {

    public ExperienceInvalidException(String message) {
        super(message);
    }

    public ExperienceInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
