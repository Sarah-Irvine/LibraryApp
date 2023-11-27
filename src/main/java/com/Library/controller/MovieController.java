package com.Library.controller;

import com.Library.model.*;
import com.Library.service.MovieService;
import com.Library.service.PeriodicalService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public List<Movie> getMovies(){
        List<Movie> movies;
        movies = movieService.findAll();
        log.debug("In the getMovies Movie method");
        return movies;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id){
        log.debug("In the getMovie Movie method: " + id);
        return movieService.findById(id);
    }

    @GetMapping("/movie/searchByTitle")
    public List<Movie>searchByTitle(@PathParam("title") String title,
                                    @PathParam("notFilter") String notFilter) {
        List<Movie> movies;
        if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByTitleNotContains(title);
        }
        else{
            movies = movieService.findByTitleContains(title);
        }
        return movies;
    }

    @GetMapping("/movie/searchByGenre")
    public List<Movie>searchByGenre(@PathParam("genre") String genre,
                                    @PathParam("notFilter") String notFilter) {
        List<Movie> movies;
        if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByGenreNotContains(genre);
        }
        else{
            movies = movieService.findByGenreContains(genre);
        }
        return movies;
    }

    @GetMapping("/movie/searchByDirector")
    public List<Movie>searchByDirector(@PathParam("director") String director,
                                       @PathParam("notFilter") String notFilter) {
        List<Movie> movies;
        if(StringUtils.isNotBlank(notFilter)){
            movies = movieService.findByDirectorNotContains(director);
        }
        else{
            movies = movieService.findByDirectorContains(director);
        }
        return movies;
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @PutMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @DeleteMapping("/movie")
    public void deleteMovie(@RequestBody Movie movie){
        movieService.delete(movie);
    }
}
