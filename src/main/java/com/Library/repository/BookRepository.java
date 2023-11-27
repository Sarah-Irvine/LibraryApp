package com.Library.repository;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book> findByTitleContains(String filter);

    List<Book> findByTitleNotContains(String notFilter);

    List<Book> findByGenreContains(String filter);

    List<Book> findByGenreNotContains(String notFilter);

    List<Book> findByAuthorNameContains(String filter);

    List<Book> findByAuthorNameNotContains(String notFilter);

}
