package com.example.book.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}
