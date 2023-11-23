package com.Library.controller;

import com.Library.model.*;
import com.Library.service.MovieService;
import com.Library.service.PeriodicalService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(@PathParam("filter") String filter,
                                           @PathParam("notFilter") String notFilter){
        List<Movie> movies = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            movies = movieService.findByTitleContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByTitleNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            movies = movieService.findByGenreContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByGenreNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            movies = movieService.findByDirectorContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByDirectorNotContains(notFilter);
        }
        else{
            movies = movieService.findAll();
        }
        log.debug("In the getMovies Movie method");
        return movies;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id){
        log.debug("In the getMovie Movie method: " + id);
        return movieService.findById(id);
    }

    @GetMapping("/movie/searchByTitle")
    public List<Movie>searchByTitle(@PathParam("title") String title) {
        return movieService.searchByTitle(title);
    }

    @GetMapping("/movie/searchByGenre")
    public List<Movie>searchByGenre(@PathParam("genre") Genre genre) {
        return movieService.searchByGenre(genre);
    }

    @GetMapping("/movie/searchByDirector")
    public List<Movie>searchByDirector(@PathParam("director") Director director) {
        return movieService.searchByDirector(director);
    }
}
