package com.Library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Periodical {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publicationDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Periodical(String title, Date publicationDate, Genre genre, Author author){
        this.title = title;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.author = author;
    }

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;



    /*
    Noting here incase needed later:
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
    String text = date.format(formatter);
    LocalDate parsedDate = LocalDate.parse(text, formatter);*/
}
