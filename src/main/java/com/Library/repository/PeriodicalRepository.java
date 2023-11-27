package com.Library.repository;

import com.Library.model.Author;
import com.Library.model.Genre;
import com.Library.model.Librarian;
import com.Library.model.Periodical;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicalRepository extends CrudRepository<Periodical,Integer> {

    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    List<Periodical> findByGenreContains(String filter);

    List<Periodical> findByGenreNotContains(String notFilter);

    List<Periodical> findByAuthorNameContains(String filter);

    List<Periodical> findByAuthorNameNotContains(String notFilter);

}
