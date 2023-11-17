package com.Library.model;

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
    private Date publicationDate;

    public Periodical(String title, Date publicationDate){
        this.title = title;
        this.publicationDate = publicationDate;
    }

    /*
    Noting here incase needed later:
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
    String text = date.format(formatter);
    LocalDate parsedDate = LocalDate.parse(text, formatter);*/
}
