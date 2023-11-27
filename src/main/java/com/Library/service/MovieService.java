package com.Library.service;

import com.Library.model.*;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(int id);


    List<Movie> findByTitleContains(String filter);

    List<Movie> findByTitleNotContains(String notFilter);

    List<Movie> searchByTitle(String title);


    List<Movie> findByGenreContains(String filter);

    List<Movie> findByGenreNotContains(String notFilter);

    List<Movie> searchByGenre(Genre genre);


    List<Movie> findByDirectorContains(String filter);

    List<Movie> findByDirectorNotContains(String notFilter);

    List<Movie> searchByDirector(Director director);

    public Movie save(Movie m);

    public void delete(Movie m);
}
