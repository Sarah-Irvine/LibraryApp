package com.library.repository;

import com.library.model.Genre;
import com.library.model.Periodical;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicalRepository extends CrudRepository<Periodical,Integer> {

    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    List<Periodical> findByGenre(Genre genre);

    List<Periodical> findByGenreNot(Genre genre);

    List<Periodical> findByAuthorNameContains(String filter);

    List<Periodical> findByAuthorNameNotContains(String notFilter);

}
