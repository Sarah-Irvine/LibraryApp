package com.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //@Nonnull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference(value = "director-movies")
    private Director director;

    public Movie(String title, Genre genre){
        this.title = title;
        this.genre = genre;
    }

}
