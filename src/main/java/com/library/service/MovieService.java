package com.library.service;

import com.library.model.*;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(int id);


    List<Movie> findByTitleContains(String filter);

    List<Movie> findByTitleNotContains(String notFilter);

    List<Movie> findByGenreContains(String genre);

    List<Movie> findByGenreNotContains(String notFilter);

    List<Movie> findByDirectorContains(String filter);

    List<Movie> findByDirectorNotContains(String notFilter);

    public Movie save(Movie m);

    public void delete(Movie m);
}
