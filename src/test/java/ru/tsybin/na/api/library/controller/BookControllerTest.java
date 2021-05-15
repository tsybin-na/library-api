package ru.tsybin.na.api.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tsybin.na.api.library.controller.api.BookController;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.exception.handler.AppExceptionHandler;
import ru.tsybin.na.api.library.service.BookService;

import java.util.ArrayList;
import java.util.List;

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
        books.add(createBookDto(1L, "Книга 1", 1L, 1L));
        books.add(createBookDto(2L, "Книга 2", 2L, 2L));
        given(bookService.findAll(0)).willReturn(books);
        String json = mapper.writeValueAsString(books);
        mvc.perform(get("/api/books")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    private BookDto createBookDto(Long id, String name, Long authorId, Long genreId) {
        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setName(name);
        bookDto.addAuthorId(authorId);
        bookDto.addGenreId(genreId);
        return bookDto;
    }

}
