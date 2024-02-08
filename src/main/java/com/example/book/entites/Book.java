package com.example.book.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    Long page;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private Author author;

    @ManyToMany(mappedBy = "favoriteBooks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reader> readers;
}
