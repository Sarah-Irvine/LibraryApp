package com.Library.service;

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
        return periodical.orElseGet(() -> new Periodical("Periodical does not exist",null));
    }

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
}
