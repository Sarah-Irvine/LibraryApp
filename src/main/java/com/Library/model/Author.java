package com.Library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Periodical> periodicals;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }
}
