package com.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director(String name){
        this.name = name;
    }
}
