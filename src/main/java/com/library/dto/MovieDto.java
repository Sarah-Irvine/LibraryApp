package com.library.dto;

import com.library.model.Director;
import com.library.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {

    private Integer id;
    private String title;

    private Genre genre;

    private Director director;

    public MovieDto (){

    }

    public MovieDto(String title, Genre genre, Director director){
        this.title = title;
        this.genre = genre;
        this.director = director;
    }


}
