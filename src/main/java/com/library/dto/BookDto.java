package com.library.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.model.Author;
import com.library.model.Genre;
import com.library.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDto {

    private Integer id;
    private String title;

    private Genre genre;

    private Author author;

    private List<UserDto> libraryUsers;

    public BookDto (){

    }

    public BookDto(Integer id, String title, Genre genre, Author author){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

}
