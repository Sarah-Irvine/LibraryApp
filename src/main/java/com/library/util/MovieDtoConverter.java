package com.library.util;

import com.library.dto.MovieDto;
import com.library.model.Movie;

public class MovieDtoConverter {
    public static MovieDto convert(Movie movie) {
        return new MovieDto(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDirector());
    }
}
