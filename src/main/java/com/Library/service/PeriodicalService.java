package com.Library.service;

import com.Library.model.Librarian;
import com.Library.model.Periodical;

import java.util.List;

public interface PeriodicalService {
    List<Periodical> findAll();

    Periodical findById(int id);

    List<Periodical> findByTitleContains(String filter);

    List<Periodical> findByTitleNotContains(String notFilter);

    List<Periodical> searchByTitle(String title);
}
