package com.example.book.exceptions;

public class InvalidAuthenticationCredentials extends RuntimeException{
    public InvalidAuthenticationCredentials(String message) {
        super(message);
    }
}
