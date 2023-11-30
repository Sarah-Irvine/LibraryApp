package com.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.model.Genre;
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

    @JsonProperty("authorName")
    private AuthorDto authorDto;

    private List<UserNameDto> libraryUsers;

}
