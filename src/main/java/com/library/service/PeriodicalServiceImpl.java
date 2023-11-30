package com.library.service;

import com.library.model.Genre;
import com.library.model.Periodical;
import com.library.repository.PeriodicalRepository;
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
        return periodical.orElseGet(() -> new Periodical("Periodical does not exist",null, null));
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


    //////////////////////////////////////////////////

    @Override
    public List<Periodical> findByGenreContains(String genreStr) {
        Genre genre = Genre.valueOf(genreStr);
        return periodicalRepository.findByGenre(genre);
    }

    @Override
    public List<Periodical> findByGenreNotContains(String genreStr) {
        Genre genre = Genre.valueOf(genreStr);
        return periodicalRepository.findByGenreNot(genre);
    }


    //////////////////////////////////////////////////

    @Override
    public List<Periodical> findByAuthorContains(String filter) {
        return periodicalRepository.findByAuthorNameContains(filter);
    }

    @Override
    public List<Periodical> findByAuthorNotContains(String notFilter) {
        return periodicalRepository.findByAuthorNameNotContains(notFilter);
    }


    //////////////////////////////////////////////////

    @Override
    public Periodical save(Periodical p){
        return periodicalRepository.save(p);
    }

    @Override
    public void delete(Periodical p) {
        periodicalRepository.delete(p);
    }
}
