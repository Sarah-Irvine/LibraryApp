package com.library.repository;

import com.library.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

    List<Movie> findByTitleContains(String filter);

    List<Movie> findByTitleNotContains(String notFilter);

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByGenreNot(Genre genre);

    List<Movie> findByDirectorNameContains(String filter);

    List<Movie> findByDirectorNameNotContains(String notFilter);

}
