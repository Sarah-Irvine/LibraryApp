package com.Library.service;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Genre;
import com.Library.model.Periodical;
import com.Library.repository.BookRepository;
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

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    //////////////////////////////////////////////////

    @Override
    public List<Book> findByGenreContains(String filter) {
        return bookRepository.findByGenreContains(filter);
    }

    @Override
    public List<Book> findByGenreNotContains(String notFilter) {
        return bookRepository.findByGenreNotContains(notFilter);
    }

    @Override
    public List<Book> searchByGenre(Genre genre) {
        return bookRepository.searchByGenre(genre);
    }

    //////////////////////////////////////////////////

    @Override
    public List<Book> findByAuthorContains(String filter) {
        return bookRepository.findByAuthorContains(filter);
    }

    @Override
    public List<Book> findByAuthorNotContains(String notFilter) {
        return bookRepository.findByAuthorNotContains(notFilter);
    }

    @Override
    public List<Book> searchByAuthor(Author author) {
        return bookRepository.searchByAuthor(author);
    }
}
