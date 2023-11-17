package com.Library.repository;

import com.Library.model.Librarian;
import com.Library.model.Periodical;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeriodicalRepository extends CrudRepository<Periodical,Integer> {

    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    @Query("SELECT new Periodical(p.title, p.publicationDate) " +
            "FROM Periodical p WHERE p.title LIKE %:title%")
    List<Periodical> searchByTitle(@Param("title") String title);

}
