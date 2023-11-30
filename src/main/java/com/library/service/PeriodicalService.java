package com.library.service;

import com.library.model.Periodical;

import java.util.List;

public interface PeriodicalService {
    List<Periodical> findAll();

    Periodical findById(int id);


    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    List<Periodical> findByGenreContains(String genre);

    List<Periodical> findByGenreNotContains(String notFilter);

    List<Periodical> findByAuthorContains(String filter);

    List<Periodical> findByAuthorNotContains(String notFilter);

    public Periodical save(Periodical p);

    public void delete(Periodical p);
}
