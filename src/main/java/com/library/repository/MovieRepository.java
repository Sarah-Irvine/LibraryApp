package com.library.repository;

import com.library.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

    List<Movie> findByTitleContains(String filter);

    List<Movie> findByTitleNotContains(String notFilter);

    List<Movie> findByGenreContains(String filter);

    List<Movie> findByGenreNotContains(String notFilter);

    List<Movie> findByDirectorNameContains(String filter);

    List<Movie> findByDirectorNameNotContains(String notFilter);

}
