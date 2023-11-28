package com.library.service;

import com.library.model.Book;
import com.library.model.Genre;
import com.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Iterable<Book> booksIts = bookRepository.findAll();
        booksIts.forEach(books::add);
        return books;
    }

    @Override
    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(() -> new Book("Book does not exist",null,null));
    }

    //////////////////////////////////////////////////

    @Override
    public List<Book> findByTitleContains(String filter) {
        return bookRepository.findByTitleContains(filter);
    }

    @Override
    public List<Book> findByTitleNotContains(String notFilter) {
        return bookRepository.findByTitleNotContains(notFilter);
    }


    //////////////////////////////////////////////////

    @Override
    public List<Book> findByGenreContains(String genreStr) {
        Genre genre = Genre.valueOf(genreStr);
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> findByGenreNotContains(String genreStr) {
        Genre genre = Genre.valueOf(genreStr);
        return bookRepository.findByGenreNot(genre); //can't use contains because there are no partials of enums
    }

    //////////////////////////////////////////////////

    @Override
    public List<Book> findByAuthorContains(String filter) {
        return bookRepository.findByAuthorNameContains(filter);
    }

    @Override
    public List<Book> findByAuthorNotContains(String notFilter) {
        return bookRepository.findByAuthorNameNotContains(notFilter);
    }

    //////////////////////////////////////////////////

    @Override
    public Book save(Book b){
        return bookRepository.save(b);
    }

    @Override
    public void delete(Book b) {
        bookRepository.delete(b);
    }
}
