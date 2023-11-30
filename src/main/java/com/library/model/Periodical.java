package com.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Periodical {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //@Nonnull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference(value = "author-periodicals")
    @JsonProperty private Author author;

    public Periodical(String title, Date publicationDate, Genre genre){
        this.title = title;
        this.publicationDate = publicationDate;
        this.genre = genre;
    }

}
