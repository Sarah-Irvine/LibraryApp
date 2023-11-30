package com.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.Author;
import com.library.model.Periodical;
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

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.library.model.Genre.MAGAZINE;
import static com.library.model.Genre.STORYBOOK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@Slf4j
public class PeriodicalTests {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper(); //converts json to java and java to json

    ResultActions resultActions;

    @Test
    public void testGettingAllPeriodicals() throws Exception{
        int expectedLength = 3;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/periodicals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Periodical[] periodicals = mapper.readValue(contentAsString, Periodical[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, periodicals.length),
                () -> assertEquals("The Banach Tarski Paradox", periodicals[0].getTitle()),
                () -> assertEquals("Vogue", periodicals[1].getTitle()),
                () -> assertEquals("Financial Times", periodicals[2].getTitle()));
    }

    //@Test
    public void testCreatePeriodical() throws Exception{
        Author author = new Author();
        author.setName("Zaggy");

        Periodical periodical = new Periodical();
        periodical.setTitle("This is my TEST Periodical!");
        String date_string = "31-10-2022";
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(date_string);
        periodical.setPublicationDate(date);
        periodical.setGenre(MAGAZINE);
        periodical.setAuthor(author);

        mapper = new ObjectMapper();

        log.debug(mapper.writeValueAsString(periodical));

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/periodical")
                        .content(mapper.writeValueAsString(periodical))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        periodical = mapper.readValue(contentAsString, Periodical.class);

        assertEquals(1,periodical.getId());

    }

    //@Test
    public void testDeletePeriodical() throws Exception{
        Periodical periodical = new Periodical();
        periodical.setTitle("This is my TEST Periodical!");
        String date_string = "31-10-2022";
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(date_string);
        periodical.setPublicationDate(date);
        periodical.setGenre(MAGAZINE);
        Author author = new Author();
        author.setName("Zaggy");
        periodical.setAuthor(author);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/periodical")
                        .content(mapper.writeValueAsString(periodical))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        periodical = mapper.readValue(contentAsString, Periodical.class);

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/periodical")
                        .content(mapper.writeValueAsString(periodical))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();


        assertEquals(200,result.getResponse().getStatus());

    }

    //@Test
    public void testUpdatePeriodical() throws Exception{
        Periodical periodical = new Periodical();
        periodical.setTitle("This is my TEST Periodical!");
        String date_string = "31-10-2022";
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(date_string);
        periodical.setPublicationDate(date);
        periodical.setGenre(MAGAZINE);
        Author author = new Author();
        author.setName("Zaggy");
        periodical.setAuthor(author);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/periodical")
                        .content(mapper.writeValueAsString(periodical))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        periodical = mapper.readValue(contentAsString, Periodical.class);

        periodical.setTitle("This is my UPDATED TEST Periodical!");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/periodical")
                        .content(mapper.writeValueAsString(periodical))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        periodical = mapper.readValue(contentAsString, Periodical.class);

        assertEquals("This is my UPDATED TEST Periodical!",periodical.getTitle());

    }
}
