package com.example.book.exceptions;

public class UsernameAlreadyExists extends RuntimeException{
    public UsernameAlreadyExists(String message) {
        super(message);
    }
}
