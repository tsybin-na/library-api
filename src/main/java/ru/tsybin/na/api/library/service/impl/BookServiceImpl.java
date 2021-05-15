package ru.tsybin.na.api.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Book;
import ru.tsybin.na.api.library.exception.EntityNotFoundException;
import ru.tsybin.na.api.library.mapper.BookMapper;
import ru.tsybin.na.api.library.mapper.BookMapperDetail;
import ru.tsybin.na.api.library.repository.BookRepository;
import ru.tsybin.na.api.library.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapperImpl;
    private final BookMapperDetail bookMapperDetailImpl;


    @Override
    @Transactional(readOnly = true)
    public List<BookDto> findAll(int page) {
        return bookMapperImpl.toDtoList(bookRepository.findAll(PageRequest.of(page, 20, Sort.by("name"))).getContent());
    }

    @Override
    @Transactional(readOnly = true)
    public BookDto findById(Long bookId) {
        return bookMapperDetailImpl.toDto(findEntityById(bookId));
    }

    @Override
    @Transactional
    public Long add(BookDto bookDto) {
        Book book = bookMapperDetailImpl.toEntity(bookDto);
        book = bookRepository.save(book);
        return book.getId();
    }

    @Override
    @Transactional
    public void update(Long bookId, BookDto bookDto) {
        Book book = findEntityById(bookId);
        bookDto.setId(bookId);
        bookMapperDetailImpl.toEntity(book, bookDto);
    }

    @Override
    @Transactional
    public void deleteById(Long bookId) {
        bookRepository.delete(findEntityById(bookId));
    }

    private Book findEntityById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("book not found, id: " + bookId));
    }

}
