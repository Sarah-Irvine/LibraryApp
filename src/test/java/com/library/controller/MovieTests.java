package com.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Director;
import com.library.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.library.model.Genre.ROMCOM;
import static com.library.model.Genre.STORYBOOK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@Slf4j
public class MovieTests {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper(); //converts json to java and java to json

    ResultActions resultActions;

    @Test
    public void testGettingAllMovies() throws Exception{
        int expectedLength = 4;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Movie[] movies = mapper.readValue(contentAsString, Movie[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, movies.length),
                () -> assertEquals("Love Actually", movies[0].getTitle()),
                () -> assertEquals("About Time", movies[1].getTitle()),
                () -> assertEquals("The Wolf of Wall Street", movies[2].getTitle()),
                () -> assertEquals("Goodfellas", movies[3].getTitle()));
    }

    @Test
    public void testCreateMovie() throws Exception{
        Director director = new Director();
        director.setName("Zaggy");

        Movie movie = new Movie();
        movie.setTitle("This is my TEST Movie!");
        movie.setGenre(ROMCOM);
        movie.setDirector(director);

        mapper = new ObjectMapper();

        log.debug(mapper.writeValueAsString(movie));

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/movie")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);

        assertEquals(1,movie.getId());

    }

    @Test
    public void testDeleteMovie() throws Exception{
        Movie movie = new Movie();
        movie.setTitle("This is my TEST Movie!");
        movie.setGenre(ROMCOM);
        Director director = new Director();
        director.setName("Zaggy");
        movie.setDirector(director);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/movie")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/movie")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();


        assertEquals(200,result.getResponse().getStatus());

    }

    @Test
    public void testUpdateMovie() throws Exception{
        Movie movie = new Movie();
        movie.setTitle("This is my TEST Movie!");
        movie.setGenre(ROMCOM);
        Director director = new Director();
        director.setName("Zaggy");
        movie.setDirector(director);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/movie")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);

        movie.setTitle("This is my UPDATED TEST Movie!");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/movie")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);

        assertEquals("This is my UPDATED TEST Movie!",movie.getTitle());

    }

}
