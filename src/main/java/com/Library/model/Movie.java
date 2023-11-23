package com.Library.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Nonnull
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
    private Director director;

    public Movie(String title, Genre genre, Director director){
        this.title = title;
        this.genre = genre;
        this.director = director;
    }

}
