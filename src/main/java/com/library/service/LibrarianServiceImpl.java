package com.library.service;

import com.library.model.Librarian;
import com.library.repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    private LibrarianRepository librarianRepository;

    @Override
    public List<Librarian> findAll() {
        List<Librarian> librarians = new ArrayList<>();
        Iterable<Librarian> librariansIts = librarianRepository.findAll();
        librariansIts.forEach(librarians::add);
        return librarians;
    }

    @Override
    public Librarian findById(int id) {
        Optional<Librarian> librarian = librarianRepository.findById(id);
        return librarian.orElseGet(() -> new Librarian("Librarian does not exist",null));
    }

    @Override
    public List<Librarian> findByNameContains(String filter) {
        return librarianRepository.findByNameContains(filter);
    }

    @Override
    public List<Librarian> findByNameNotContains(String notFilter) {
        return librarianRepository.findByNameNotContains(notFilter);
    }

    @Override
    public Librarian save(Librarian l){
        return librarianRepository.save(l);
    }

    @Override
    public void delete(Librarian l) {
        librarianRepository.delete(l);
    }
}
