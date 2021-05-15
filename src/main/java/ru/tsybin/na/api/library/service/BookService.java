package ru.tsybin.na.api.library.service;

import ru.tsybin.na.api.library.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findAll(int page);

    BookDto findById(Long bookId);

    Long add(BookDto bookDto);

    void update(Long bookId, BookDto bookDto);

    void deleteById(Long bookId);

}
