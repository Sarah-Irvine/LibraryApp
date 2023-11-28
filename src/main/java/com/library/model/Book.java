package com.library.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Nonnull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    //@JsonBackReference
    //@JsonIgnore
    private Author author;

    public Book(String title, Genre genre, Author author){
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

}
