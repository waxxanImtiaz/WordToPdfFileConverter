package com.example.filedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TheFileNotFoundException extends RuntimeException {
    public TheFileNotFoundException(String message) {
        super(message);
    }

    public TheFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
