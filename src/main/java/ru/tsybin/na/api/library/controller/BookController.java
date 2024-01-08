package ru.tsybin.na.api.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookService bookService;

    @GetMapping("api/books")
    public List<BookDto> findAll(@RequestParam(defaultValue = "0") int page) {
        return bookService.findAll(page);
    }

    @GetMapping("api/books/{bookId}")
    public BookDto findById(@PathVariable UUID bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("api/books")
    public UUID add(@Valid @RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PutMapping("api/books/{bookId}")
    public void update(@PathVariable UUID bookId, @Valid @RequestBody BookDto bookDto) {
        bookService.update(bookId, bookDto);
    }

    @DeleteMapping("api/books/{bookId}")
    public void deleteById(@PathVariable UUID bookId) {
        bookService.deleteById(bookId);
    }

}
