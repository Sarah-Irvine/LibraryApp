package com.Library.repository;

import com.Library.model.Author;
import com.Library.model.Genre;
import com.Library.model.Librarian;
import com.Library.model.Periodical;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeriodicalRepository extends CrudRepository<Periodical,Integer> {

    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    @Query("SELECT new Periodical(p.title, p.publicationDate, p.genre, p.author) " +
            "FROM Periodical p WHERE p.title LIKE %:title%")
    List<Periodical> searchByTitle(@Param("title") String title);


    List<Periodical> findByGenreContains(String filter);

    List<Periodical> findByGenreNotContains(String notFilter);

    @Query("SELECT new Periodical(p.title, p.publicationDate, p.genre, p.author) " +
            "FROM Periodical p WHERE p.genre LIKE %:genre%")
    List<Periodical> searchByGenre(@Param("genre") Genre genre);


    List<Periodical> findByAuthorContains(String filter);

    List<Periodical> findByAuthorNotContains(String notFilter);

    @Query("SELECT new Periodical(p.title, p.publicationDate, p.genre, p.author) " +
            "FROM Periodical p WHERE p.author LIKE %:author%")
    List<Periodical> searchByAuthor(@Param("author") Author author);

}
