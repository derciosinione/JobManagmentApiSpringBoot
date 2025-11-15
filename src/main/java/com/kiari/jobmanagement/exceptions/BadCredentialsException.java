package com.kiari.jobmanagement.exceptions;


import org.springframework.security.core.AuthenticationException;

public class BadCredentialsException extends AuthenticationException {
    public BadCredentialsException() {
        super("Invalid credentials");
    }

    public BadCredentialsException(String message) {
        super(message);
    }
}