package com.library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Director {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "director")
    @JsonManagedReference(value = "director-movies")
    private List<Movie> movies;

    public Director(String name){
        this.name = name;
    }
}
