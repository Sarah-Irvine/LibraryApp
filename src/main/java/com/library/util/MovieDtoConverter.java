package com.library.util;

import com.library.dto.AuthorDto;
import com.library.dto.DirectorDto;
import com.library.dto.MovieDto;
import com.library.model.Author;
import com.library.model.Director;
import com.library.model.Movie;

public class MovieDtoConverter {
    public static MovieDto convert(Movie movie) {
        Director director = movie.getDirector();
        DirectorDto directorDto = new DirectorDto(director.getName());
        return new MovieDto(movie.getId(), movie.getTitle(), movie.getGenre(), directorDto);
    }
}
