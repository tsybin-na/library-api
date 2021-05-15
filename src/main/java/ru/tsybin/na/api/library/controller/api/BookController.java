package ru.tsybin.na.api.library.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("api/books")
    public List<BookDto> findAll(@RequestParam(defaultValue = "0") int page) {
        return bookService.findAll(page);
    }

    @GetMapping("api/books/{bookId}")
    public BookDto findById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("api/books")
    public Long add(@Valid @RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PutMapping("api/books/{bookId}")
    public void update(@PathVariable Long bookId, @Valid @RequestBody BookDto bookDto) {
        bookService.update(bookId, bookDto);
    }

    @DeleteMapping("api/books/{bookId}")
    public void deleteById(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }

}
