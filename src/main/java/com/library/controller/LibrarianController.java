package com.library.controller;

import com.library.model.Librarian;
import com.library.service.LibrarianService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class LibrarianController {

    private final LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService){
        this.librarianService = librarianService;
    }

    @GetMapping("/librarians")
    public List<Librarian> getLibrarians(){
        List<Librarian> librarians;
        librarians = librarianService.findAll();
        log.debug("In the getLibrarians Librarian method");
        return librarians;
    }

    @GetMapping("/librarians/{id}")
    public Librarian getLibrarian(@PathVariable int id){
        log.debug("In the getLibrarian Librarian method: " + id);
        return librarianService.findById(id);
    }

    @GetMapping("/librarian/search")
    public List<Librarian>searchByName(@PathParam("name") String name,
                                       @PathParam("notFilter") String notFilter) {
        List<Librarian> librarians;
        if(StringUtils.isNotBlank(notFilter)){
            librarians = librarianService.findByNameNotContains(name);
        }
        else{
            librarians = librarianService.findByNameContains(name);
        }
        return librarians;
    }

    @PostMapping("/librarian")
    public Librarian createLibrarian(@RequestBody Librarian librarian){
        return librarianService.save(librarian);
    }

    @PutMapping("/librarian")
    public Librarian updateLibrarian(@RequestBody Librarian librarian){
        return librarianService.save(librarian);
    }

    @DeleteMapping("/librarian")
    public void deleteLibrarian(@RequestBody Librarian librarian){
        librarianService.delete(librarian);
    }


}
