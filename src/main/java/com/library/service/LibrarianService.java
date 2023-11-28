package com.library.service;

import com.library.model.Librarian;

import java.util.List;

public interface LibrarianService {

    List<Librarian> findAll();

    Librarian findById(int id);

    List<Librarian> findByNameContains(String filter);

    List<Librarian> findByNameNotContains(String notFilter);

    public Librarian save(Librarian l);

    public void delete(Librarian l);
}
