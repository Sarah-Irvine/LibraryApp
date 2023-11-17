package com.Library.service;

import com.Library.model.Librarian;
import com.Library.model.User;

import java.util.List;

public interface LibrarianService {

    List<Librarian> findAll();

    Librarian findById(int id);

    List<Librarian> findByNameContains(String filter);

    List<Librarian> findByNameNotContains(String notFilter);

    List<Librarian> searchByName(String name);
}
