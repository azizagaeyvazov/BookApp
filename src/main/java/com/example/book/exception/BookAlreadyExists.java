package com.example.book.exception;

public class BookAlreadyExists extends RuntimeException{
    public BookAlreadyExists(String message) {
        super(message);
    }
}
