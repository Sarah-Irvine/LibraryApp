package com.Library.service;

import com.Library.model.Author;
import com.Library.model.Genre;
import com.Library.model.Librarian;
import com.Library.model.Periodical;

import java.util.List;

public interface PeriodicalService {
    List<Periodical> findAll();

    Periodical findById(int id);


    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    List<Periodical> searchByTitle(String title);


    List<Periodical> findByGenreContains(String filter);

    List<Periodical> findByGenreNotContains(String notFilter);

    List<Periodical> searchByGenre(Genre genre);


    List<Periodical> findByAuthorContains(String filter);

    List<Periodical> findByAuthorNotContains(String notFilter);

    List<Periodical> searchByAuthor(Author author);

    public Periodical save(Periodical p);

    public void delete(Periodical p);
}
