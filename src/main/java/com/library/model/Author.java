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
    //@JsonManagedReference
    private List<Periodical> periodicals;

    //@JsonSerialize(using = BookSerializer.class)
    //@JsonDeserialize(using = BookDeserializer.class)
    @OneToMany(mappedBy = "author")
    //@JsonManagedReference
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }

}
