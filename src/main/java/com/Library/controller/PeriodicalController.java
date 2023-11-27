package com.Library.controller;

import com.Library.model.*;
import com.Library.service.PeriodicalService;
import com.Library.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class PeriodicalController {

    private final PeriodicalService periodicalService;

    public PeriodicalController(PeriodicalService periodicalService){
        this.periodicalService = periodicalService;
    }

    @GetMapping("/periodicals")
    public List<Periodical> getPeriodicals(){
        List<Periodical> periodicals;
        periodicals = periodicalService.findAll();
        log.debug("In the getPeriodicals Periodicals method");
        return periodicals;
    }

    @GetMapping("/periodicals/{id}")
    public Periodical getPeriodical(@PathVariable int id){
        log.debug("In the getPeriodical Periodicals method: " + id);
        return periodicalService.findById(id);
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
