package com.library.util;

import com.library.dto.AuthorDto;
import com.library.dto.BookDto;
import com.library.dto.UserDto;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class BookDtoConverter {

    public static BookDto convert(Book book) {
        List<User> libraryUsers = book.getLibraryUsers();
        List<UserDto> libraryUserDtos = new ArrayList<>();
        for (User user: libraryUsers) {
            libraryUserDtos.add(new UserDto(user.getName()));
        }
        Author author = book.getAuthor();
        AuthorDto authorDto = new AuthorDto(author.getName());
        return new BookDto(book.getId(), book.getTitle(), book.getGenre(), authorDto, libraryUserDtos);
    }

}
