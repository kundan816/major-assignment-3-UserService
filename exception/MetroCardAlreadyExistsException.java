package com.NammaMetro.UserService.exception;

public class MetroCardAlreadyExistsException extends RuntimeException {
    public MetroCardAlreadyExistsException(String message) {
        super(message);
    }
}
