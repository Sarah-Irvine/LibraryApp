package com.Library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Periodical> periodicals;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }
}
