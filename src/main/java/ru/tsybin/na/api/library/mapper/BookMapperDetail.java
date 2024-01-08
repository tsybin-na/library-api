package ru.tsybin.na.api.library.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Author;
import ru.tsybin.na.api.library.entity.Book;
import ru.tsybin.na.api.library.exception.EntityNotFoundException;
import ru.tsybin.na.api.library.repository.AuthorRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public abstract class BookMapperDetail implements BookMapper {

    @Autowired
    private AuthorRepository authorRepository;

    public abstract void toEntity(@MappingTarget Book book, BookDto bookDto);

    @AfterMapping
    public void toDtoAfterMapping(Book book, @MappingTarget BookDto bookDto) {
        List<UUID> authorsIds = book.getAuthors().stream().map(Author::getId).collect(Collectors.toList());
        bookDto.setAuthorsIds(authorsIds);
    }

    @AfterMapping
    public void toEntityAfterMapping(@MappingTarget Book book, BookDto bookDto) {
        List<Author> authors = book.getAuthors();
        authors.clear();
        bookDto.getAuthorsIds().forEach(authorId -> {
            Author author = authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("author not found, id: " + authorId));
            authors.add(author);
        });
    }

}
