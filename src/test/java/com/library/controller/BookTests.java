package com.library.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.library.dto.BookDto;
import com.library.model.Author;
import com.library.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.client.RestTemplate;

import static com.library.model.Genre.STORYBOOK;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@Slf4j
public class BookTests {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper(); //converts json to java and java to json

    ResultActions resultActions;

    @Test
    public void testGettingAllBooks() throws Exception{
        int expectedLength = 5;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Book[] books = mapper.readValue(contentAsString, Book[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, books.length),
                () -> assertEquals("Winnie The Pooh", books[0].getTitle()),
                () -> assertEquals("The Little Mermaid", books[1].getTitle()),
                () -> assertEquals("Where the Crawdads Sing", books[2].getTitle()),
                () -> assertEquals("Lessons in Chemistry", books[3].getTitle()),
                () -> assertEquals("The Midnight Library", books[4].getTitle()));
    }

    @Test
    void testGet() {
        RestTemplate restTemplate = new RestTemplate();
        BookDto book = restTemplate.getForObject("http://localhost:8080/books/100", BookDto.class);
        assertNotNull(book);
        System.out.println(book.getTitle());
        System.out.println(book.getAuthorDto());
    }

    @Test
    void testPut() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        BookDto book = restTemplate.getForObject("http://localhost:8080/book", BookDto.class);

        book.setTitle("Pooh bear");
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(book);
        System.out.println(str);

        restTemplate.put("http://localhost:8080/books", book);

        assertTrue(true);
    }

    //@Test
    public void testCreateBook() throws Exception{
        Book book = new Book();
        book.setTitle("This is my TEST Book!");
        book.setGenre(STORYBOOK);
        Author author = new Author();
        author.setName("Zaggy");
        book.setAuthor(author);

        mapper = new ObjectMapper();

        log.debug(mapper.writeValueAsString(book));

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        book = mapper.readValue(contentAsString, Book.class);

        assertEquals(1,book.getId());

    }

    //@Test
    public void testDeleteBook() throws Exception{
        Book book = new Book();
        book.setTitle("This is my TEST Book!");
        book.setGenre(STORYBOOK);
        Author author = new Author();
        author.setName("Zaggy");
        book.setAuthor(author);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        book = mapper.readValue(contentAsString, Book.class);

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/book")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();


        assertEquals(200,result.getResponse().getStatus());

    }

    //@Test
    public void testUpdateBook() throws Exception{
        Book book = new Book();
        book.setTitle("This is my TEST Book!");
        book.setGenre(STORYBOOK);
        Author author = new Author();
        author.setName("Zaggy");
        book.setAuthor(author);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON) //asking for JSON
                        .accept(MediaType.APPLICATION_JSON)) //only accepting JSON
                .andExpect(MockMvcResultMatchers.status().isOk()); //Expect JSON

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        book = mapper.readValue(contentAsString, Book.class);

        book.setTitle("This is my UPDATED TEST Book!");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/book")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //builders are a type of design pattern

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        book = mapper.readValue(contentAsString, Book.class);

        assertEquals("This is my UPDATED TEST Book!",book.getTitle());

    }
}
