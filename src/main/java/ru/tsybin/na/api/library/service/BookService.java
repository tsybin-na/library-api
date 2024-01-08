package ru.tsybin.na.api.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Book;
import ru.tsybin.na.api.library.exception.EntityNotFoundException;
import ru.tsybin.na.api.library.mapper.BookMapper;
import ru.tsybin.na.api.library.mapper.BookMapperDetail;
import ru.tsybin.na.api.library.repository.BookRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapperImpl;
    private final BookMapperDetail bookMapperDetailImpl;


    @Transactional(readOnly = true)
    public List<BookDto> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 20, Sort.by("name"));
        return bookMapperImpl.toDtoList(bookRepository.findAll(pageable)
                .getContent());
    }

    @Transactional(readOnly = true)
    public BookDto findById(UUID bookId) {
        Book book = findEntityById(bookId);
        return bookMapperDetailImpl.toDto(book);
    }

    @Transactional
    public UUID add(BookDto bookDto) {
        Book book = bookMapperDetailImpl.toEntity(bookDto);
        book = bookRepository.save(book);
        return book.getId();
    }

    @Transactional
    public void update(UUID bookId, BookDto bookDto) {
        Book book = findEntityById(bookId);
        bookDto.setId(bookId);
        bookMapperDetailImpl.toEntity(book, bookDto);
    }

    @Transactional
    public void deleteById(UUID bookId) {
        Book book = findEntityById(bookId);
        bookRepository.delete(book);
    }

    private Book findEntityById(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("book not found, id: " + bookId));
    }

}
