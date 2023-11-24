package com.Library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Nonnull
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Author author;

    public Book(String title, Genre genre, Author author){
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

}
