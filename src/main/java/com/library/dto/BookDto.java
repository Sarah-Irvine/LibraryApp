package com.library.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.model.Author;
import com.library.model.Genre;
import com.library.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String title;

    private Genre genre;

    @JsonProperty("Author Name")
    private AuthorDto authorDto;

    private List<UserDto> libraryUsers;

}
