package ru.tsybin.na.api.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.exception.handler.AppExceptionHandler;
import ru.tsybin.na.api.library.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private AppExceptionHandler appExceptionHandler;

    @Autowired
    private MockMvc mvc;

    @Test
    public void findAll() throws Exception {
        List<BookDto> books = new ArrayList<>();
        books.add(createBookDto(UUID.fromString("a13c494e-a06f-4ec3-b9f3-951228f72f9d"), "Книга 1", UUID.fromString("c87074c2-1ac6-446b-bb40-043e27d476c8")));
        books.add(createBookDto(UUID.fromString("7ac157f5-a939-4e0f-b8b0-e3541b0069da"), "Книга 2", UUID.fromString("d465248a-ba75-47ee-8b65-74b2862c2e90")));
        given(bookService.findAll(0)).willReturn(books);
        String json = mapper.writeValueAsString(books);
        mvc.perform(get("/api/books")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    private BookDto createBookDto(UUID id, String name, UUID authorId) {
        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setName(name);
        bookDto.addAuthorId(authorId);
        return bookDto;
    }

}
