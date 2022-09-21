package com.codewitharjun.springboot.crud.exception;

import org.springframework.stereotype.Component;

/* Created by Arjun Gautam */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
