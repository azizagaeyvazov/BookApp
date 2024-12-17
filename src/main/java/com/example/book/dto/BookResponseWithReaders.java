package com.example.book.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseWithReaders {

    private String title;

    private Long page;

    private List<ReaderResponse> readers;
}
