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

    @Query("SELECT new Movie(m.title, m.genre, m.director) " +
            "FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> searchByTitle(@Param("title") String title);


    List<Movie> findByGenreContains(String filter);

    List<Movie> findByGenreNotContains(String notFilter);

    @Query("SELECT new Movie(m.title, m.genre, m.director) " +
            "FROM Movie m WHERE m.genre LIKE %:genre%")
    List<Movie> searchByGenre(@Param("genre") Genre genre);


    List<Movie> findByDirectorContains(String filter);

    List<Movie> findByDirectorNotContains(String notFilter);

    @Query("SELECT new Movie(m.title, m.genre, m.director) " +
            "FROM Movie m WHERE m.director LIKE %:director%")
    List<Movie> searchByDirector(@Param("director") Director director);
}
