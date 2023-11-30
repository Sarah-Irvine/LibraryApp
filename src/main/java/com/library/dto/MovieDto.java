package com.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.model.Director;
import com.library.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Integer id;
    private String title;

    private Genre genre;

    @JsonProperty("Director Name")
    private DirectorDto directorDto;

}
