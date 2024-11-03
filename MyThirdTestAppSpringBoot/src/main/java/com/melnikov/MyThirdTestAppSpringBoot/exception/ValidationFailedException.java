package com.melnikov.MyThirdTestAppSpringBoot.exception;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(String message) {
        super(message);
    }

    public ValidationFailedException(String message, String details) {
        super(message + ": " + details);
    }
}
