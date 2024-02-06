package com.example.book.exception;

public class InvalidAuthenticationCredentials extends RuntimeException{
    public InvalidAuthenticationCredentials(String message) {
        super(message);
    }
}
