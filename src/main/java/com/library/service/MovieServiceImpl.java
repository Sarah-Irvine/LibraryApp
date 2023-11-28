package com.library.service;

import com.library.model.Movie;
import com.library.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> moviesIts = movieRepository.findAll();
        moviesIts.forEach(movies::add);
        return movies;
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElseGet(() -> new Movie("Movie does not exist",null, null));
    }

    //////////////////////////////////////////////////

    @Override
    public List<Movie> findByTitleContains(String filter) {
        return movieRepository.findByTitleContains(filter);
    }

    @Override
    public List<Movie> findByTitleNotContains(String notFilter) {
        return movieRepository.findByTitleNotContains(notFilter);
    }

    //////////////////////////////////////////////////

    @Override
    public List<Movie> findByGenreContains(String filter) {
        return movieRepository.findByGenreContains(filter);
    }

    @Override
    public List<Movie> findByGenreNotContains(String notFilter) {
        return movieRepository.findByGenreNotContains(notFilter);
    }


    //////////////////////////////////////////////////

    @Override
    public List<Movie> findByDirectorContains(String filter) {
        return movieRepository.findByDirectorNameContains(filter);
    }

    @Override
    public List<Movie> findByDirectorNotContains(String notFilter) {
        return movieRepository.findByDirectorNameNotContains(notFilter);
    }


    //////////////////////////////////////////////////

    @Override
    public Movie save(Movie m){
        return movieRepository.save(m);
    }

    @Override
    public void delete(Movie m) {
        movieRepository.delete(m);
    }
}
