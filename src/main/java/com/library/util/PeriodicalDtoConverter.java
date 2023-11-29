package com.library.util;

import com.library.dto.PeriodicalDto;
import com.library.model.Periodical;

public class PeriodicalDtoConverter {

    public static PeriodicalDto convert(Periodical periodical) {
        return new PeriodicalDto(periodical.getId(), periodical.getTitle(), periodical.getPublicationDate(), periodical.getGenre(), periodical.getAuthor());
    }

}
