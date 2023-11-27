package com.Library.controller;

import com.Library.model.Author;
import com.Library.model.Genre;
import com.Library.model.Periodical;
import com.Library.model.User;
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
    public List<Periodical> getPeriodicals(@PathParam("filter") String filter,
                                           @PathParam("notFilter") String notFilter){
        List<Periodical> periodicals = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            periodicals = periodicalService.findByTitleContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByTitleNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            periodicals = periodicalService.findByGenreContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByGenreNotContains(notFilter);
        }
        else if(StringUtils.isNotBlank(filter)){
            periodicals = periodicalService.findByAuthorContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            periodicals = periodicalService.findByAuthorNotContains(notFilter);
        }
        else{
            periodicals = periodicalService.findAll();
        }
        log.debug("In the getPeriodicals Periodicals method");
        return periodicals;
    }

    @GetMapping("/periodicals/{id}")
    public Periodical getPeriodical(@PathVariable int id){
        log.debug("In the getPeriodical Periodicals method: " + id);
        return periodicalService.findById(id);
    }

    @GetMapping("/periodical/searchByTitle")
    public List<Periodical>searchByTitle(@PathParam("title") String title) {
        return periodicalService.searchByTitle(title);
    }

    @GetMapping("/periodical/searchByGenre")
    public List<Periodical>searchByGenre(@PathParam("genre") Genre genre) {
        return periodicalService.searchByGenre(genre);
    }

    @GetMapping("/periodical/searchByAuthor")
    public List<Periodical>searchByAuthor(@PathParam("author") Author author) {
        return periodicalService.searchByAuthor(author);
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
