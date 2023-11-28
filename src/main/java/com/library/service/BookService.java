package com.library.service;

import com.library.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);

    List<Book> findByTitleContains(String filter);

    List<Book> findByTitleNotContains(String notFilter);

    List<Book> findByGenreContains(String genre);

    List<Book> findByGenreNotContains(String notFilter);

    List<Book> findByAuthorContains(String filter);

    List<Book> findByAuthorNotContains(String notFilter);

    public Book save(Book b);

    public void delete(Book b);
}
