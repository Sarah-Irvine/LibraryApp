package com.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.Librarian;
import com.library.model.User;
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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@Slf4j
public class LibrarianTests {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper(); //converts json to java and java to json

    ResultActions resultActions;

    @Test
    public void testGettingAllLibrarians() throws Exception{
        int expectedLength = 3;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/librarians")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Librarian[] librarians = mapper.readValue(contentAsString, Librarian[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, librarians.length));
    }
}
