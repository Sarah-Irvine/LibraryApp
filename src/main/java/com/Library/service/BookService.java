package com.Library.service;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Genre;
import com.Library.model.Periodical;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);


    List<Book> findByTitleContains(String filter);

    List<Book> findByTitleNotContains(String notFilter);

    List<Book> searchByTitle(String title);


    List<Book> findByGenreContains(String filter);

    List<Book> findByGenreNotContains(String notFilter);

    List<Book> searchByGenre(Genre genre);


    List<Book> findByAuthorContains(String filter);

    List<Book> findByAuthorNotContains(String notFilter);

    List<Book> searchByAuthor(Author author);
}
