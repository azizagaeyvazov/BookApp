package com.example.book.exception;

public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super(message);
    }
}
