package com.library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.library.util.BookDeserializer;
import com.library.util.BookSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference(value = "author-periodicals")
    private List<Periodical> periodicals;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference(value = "author-books")
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }

}
