package com.Library.controller;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Genre;
import com.Library.model.Periodical;
import com.Library.service.BookService;
import com.Library.service.PeriodicalService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(@PathParam("filter") String filter,
                               @PathParam("notFilter") String notFilter){
        List<Book> books = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            books = bookService.findByTitleContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByTitleNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            books = bookService.findByGenreContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByGenreNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            books = bookService.findByAuthorContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByAuthorNotContains(notFilter);
        }
        else{
            books = bookService.findAll();
        }
        log.debug("In the getBooks Book method");
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        log.debug("In the getBook Books method: " + id);
        return bookService.findById(id);
    }

    @GetMapping("/book/searchByTitle")
    public List<Book>searchByTitle(@PathParam("title") String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/book/searchByGenre")
    public List<Book>searchByGenre(@PathParam("genre") Genre genre) {
        return bookService.searchByGenre(genre);
    }

    @GetMapping("/book/searchByAuthor")
    public List<Book>searchByAuthor(@PathParam("author") Author author) {
        return bookService.searchByAuthor(author);
    }
}
