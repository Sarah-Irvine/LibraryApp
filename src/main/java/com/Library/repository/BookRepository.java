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

    @Query("SELECT new Book(b.title, b.genre, b.author) " +
            "FROM Book b WHERE b.title LIKE %:title%")
    List<Book> searchByTitle(@Param("title") String title);


    List<Book> findByGenreContains(String filter);

    List<Book> findByGenreNotContains(String notFilter);

    @Query("SELECT new Book(b.title, b.genre, b.author) " +
            "FROM Book b WHERE b.genre LIKE %:genre%")
    List<Book> searchByGenre(@Param("genre") Genre genre);


    List<Book> findByAuthorContains(String filter);

    List<Book> findByAuthorNotContains(String notFilter);

    @Query("SELECT new Book(b.title, b.genre, b.author) " +
            "FROM Book b WHERE b.author LIKE %:author%")
    List<Book> searchByAuthor(@Param("author") Author author);
}
