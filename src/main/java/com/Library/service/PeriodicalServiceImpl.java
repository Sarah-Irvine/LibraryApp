package com.Library.service;

import com.Library.model.Author;
import com.Library.model.Genre;
import com.Library.model.Librarian;
import com.Library.model.Periodical;
import com.Library.repository.PeriodicalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PeriodicalServiceImpl implements PeriodicalService{

    private PeriodicalRepository periodicalRepository;

    @Override
    public List<Periodical> findAll() {
        List<Periodical> periodicals = new ArrayList<>();
        Iterable<Periodical> periodicalsIts = periodicalRepository.findAll();
        periodicalsIts.forEach(periodicals::add);
        return periodicals;
    }

    @Override
    public Periodical findById(int id) {
        Optional<Periodical> periodical = periodicalRepository.findById(id);
        return periodical.orElseGet(() -> new Periodical("Periodical does not exist",null, null,null));
    }

    //////////////////////////////////////////////////

    @Override
    public List<Periodical> findByTitleContains(String filter) {
        return periodicalRepository.findByTitleContains(filter);
    }

    @Override
    public List<Periodical> findByTitleNotContains(String notFilter) {
        return periodicalRepository.findByTitleNotContains(notFilter);
    }

    @Override
    public List<Periodical> searchByTitle(String title) {
        return periodicalRepository.searchByTitle(title);
    }

    //////////////////////////////////////////////////

    @Override
    public List<Periodical> findByGenreContains(String filter) {
        return periodicalRepository.findByGenreContains(filter);
    }

    @Override
    public List<Periodical> findByGenreNotContains(String notFilter) {
        return periodicalRepository.findByGenreNotContains(notFilter);
    }

    @Override
    public List<Periodical> searchByGenre(Genre genre) {
        return periodicalRepository.searchByGenre(genre);
    }

    //////////////////////////////////////////////////


    @Override
    public List<Periodical> findByAuthorContains(String filter) {
        return periodicalRepository.findByAuthorContains(filter);
    }

    @Override
    public List<Periodical> findByAuthorNotContains(String notFilter) {
        return periodicalRepository.findByAuthorNotContains(notFilter);
    }

    @Override
    public List<Periodical> searchByAuthor(Author author) {
        return periodicalRepository.searchByAuthor(author);
    }
}
