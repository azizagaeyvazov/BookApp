package com.example.book.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookResponseWithReaders {

    private Long id;

    private String title;

    private Long page;

    private List<ReaderResponse> readers;
}
