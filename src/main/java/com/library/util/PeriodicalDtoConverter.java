package com.library.util;

import com.library.dto.AuthorDto;
import com.library.dto.PeriodicalDto;
import com.library.model.Author;
import com.library.model.Periodical;

public class PeriodicalDtoConverter {

    public static PeriodicalDto convert(Periodical periodical) {
        Author author = periodical.getAuthor();
        AuthorDto authorDto = new AuthorDto(author.getName());
        return new PeriodicalDto(periodical.getId(), periodical.getTitle(), periodical.getPublicationDate(), periodical.getGenre(), authorDto);
    }

}
