package com.library.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.library.model.Book;

import java.io.IOException;
import java.util.List;

public class BookSerializer extends JsonSerializer<List<Book>> {

    @Override
    public void serialize(List<Book> value, JsonGenerator jgen,SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        for (Book book : value) {
                jgen.writeStartObject();
                jgen.writeObjectField("book", book);
                jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }

}

