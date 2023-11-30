package com.library.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nonnull;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //@Nonnull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference(value = "author-books")
    @JsonProperty private Author author;

    public Book(String title, Genre genre){
        this.title = title;
        this.genre = genre;
    }

    @ManyToMany
    @JoinTable(name="user_book",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    @JsonBackReference(value = "users-books")
    @JsonIgnore
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    private List<User> libraryUsers;

}
