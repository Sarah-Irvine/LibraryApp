package com.library.util;

import com.library.dto.BookTitleDto;
import com.library.dto.UserDto;
import com.library.dto.UserNameDto;
import com.library.model.Book;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConverter {

    public static UserDto convert(User user) {
        List<Book> booksBorrowed = user.getBooksBorrowed();
        List<BookTitleDto> booksBorrowedDtos = new ArrayList<>();
        for (Book book: booksBorrowed) {
            booksBorrowedDtos.add(new BookTitleDto(book.getTitle()));
        }
        return new UserDto(user.getId(), user.getName(), user.getPhoneNumber(), user.getAddress(), booksBorrowedDtos);
    }

}
