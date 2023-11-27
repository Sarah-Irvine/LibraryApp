package com.Library.repository;

import com.Library.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
