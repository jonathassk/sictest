package com.example.demo.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PollNotFoundException extends RuntimeException{
    public PollNotFoundException(String message) {
        super(message);
    }
}


