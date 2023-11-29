package com.library.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.model.Author;
import com.library.model.Genre;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PeriodicalDto {

    private Integer id;
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publicationDate;

    private Genre genre;

    private Author author;

    public PeriodicalDto (){

    }

    public PeriodicalDto(String title, Date publicationDate, Genre genre, Author author){
        this.title = title;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.author = author;
    }

}
