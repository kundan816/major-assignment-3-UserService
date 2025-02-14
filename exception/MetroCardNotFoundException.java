package com.NammaMetro.UserService.exception;

public class MetroCardNotFoundException extends RuntimeException {
    public MetroCardNotFoundException(String message) {
        super(message);
    }
}
