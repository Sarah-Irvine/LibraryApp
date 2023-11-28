package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        List<Book> books;
        books = bookService.findAll();
        log.debug("In the getBooks Book method");
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        log.debug("In the getBook Books method: " + id);
        return bookService.findById(id);
    }

    @GetMapping("/book/searchByTitle")
    public List<Book>searchByTitle(@PathParam("title") String title,
                                   @PathParam("notFilter") String notFilter) {
        List<Book> books;
        if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByTitleNotContains(title);
        }
        else{
            books = bookService.findByTitleContains(title);
        }
        return books;
    }

    @GetMapping("/book/searchByGenre")
    public List<Book>searchByGenre(@PathParam("genre") String genre,
                                   @PathParam("notFilter") String notFilter) {
        List<Book> books;
        if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByGenreNotContains(genre);
        }
        else{
            books = bookService.findByGenreContains(genre);
        }
        return books;
    }

    @GetMapping("/book/searchByAuthor")
    public List<Book>searchByAuthor(@PathParam("author") String author,
                                    @PathParam("notFilter") String notFilter) {
        List<Book> books;
        if(StringUtils.isNotBlank(notFilter)){
            books = bookService.findByAuthorNotContains(author);
        }
        else{
            books = bookService.findByAuthorContains(author);
        }
        return books;
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        log.debug(String.valueOf(book));
        return bookService.save(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/book")
    public void deleteBook(@RequestBody Book book){
        bookService.delete(book);
    }
}
