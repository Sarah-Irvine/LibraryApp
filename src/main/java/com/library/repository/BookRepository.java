package com.library.repository;

import com.library.model.Book;
import com.library.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book> findByTitleContains(String filter);

    List<Book> findByTitleNotContains(String notFilter);

    List<Book> findByGenre(Genre genre);

    List<Book> findByGenreNot(Genre genre);

    List<Book> findByAuthorNameContains(String filter);

    List<Book> findByAuthorNameNotContains(String notFilter);

}
