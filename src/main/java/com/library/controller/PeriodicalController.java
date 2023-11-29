package com.library.controller;

import com.library.dto.PeriodicalDto;
import com.library.model.*;
import com.library.repository.PeriodicalRepository;
import com.library.service.PeriodicalService;
import com.library.util.PeriodicalDtoConverter;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@Slf4j
public class PeriodicalController {

    private final PeriodicalService periodicalService;

    private PeriodicalRepository periodicalRepository;

    @GetMapping("/periodicals")
    public List<Periodical> getPeriodicals(){
        List<Periodical> periodicals;
        periodicals = periodicalService.findAll();
        log.debug("In the getPeriodicals Periodicals method");
        return periodicals;
    }

    @GetMapping("/periodicals/{id}")
    public PeriodicalDto getPeriodicalById(@PathVariable("id") int id){
        log.debug("In the getPeriodical Periodicals method: " + id);
        Periodical periodical = periodicalRepository.findById(id).orElseGet(Periodical::new);
        return PeriodicalDtoConverter.convert(periodical);
    }

    @GetMapping("/periodical/searchByTitle")
    public List<Periodical>searchByTitle(@PathParam("title") String title,
                                         @PathParam("notFilter") String notFilter) {
        List<Periodical> periodicals;
        if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByTitleNotContains(title);
        }
        else{
            periodicals = periodicalService.findByTitleContains(title);
        }
        return periodicals;
    }

    @GetMapping("/periodical/searchByGenre")
    public List<Periodical>searchByGenre(@PathParam("genre") String genre,
                                         @PathParam("notFilter") String notFilter) {
        List<Periodical> periodicals;
        if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByGenreNotContains(genre);
        }
        else{
            periodicals = periodicalService.findByGenreContains(genre);
        }
        return periodicals;
    }

    @GetMapping("/periodical/searchByAuthor")
    public List<Periodical>searchByAuthor(@PathParam("author") String author,
                                          @PathParam("notFilter") String notFilter) {
        List<Periodical> periodicals;
        if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByAuthorNotContains(author);
        }
        else{
            periodicals = periodicalService.findByAuthorContains(author);
        }
        return periodicals;
    }

    @PostMapping("/periodical")
    public Periodical createPeriodical(@RequestBody Periodical periodical){ return periodicalService.save(periodical); }

    @PutMapping("/periodical")
    public Periodical updatePeriodical(@RequestBody Periodical periodical){ return periodicalService.save(periodical); }

    @DeleteMapping("/periodical")
    public void deletePeriodical(@RequestBody Periodical periodical){
        periodicalService.delete(periodical);
    }

}
