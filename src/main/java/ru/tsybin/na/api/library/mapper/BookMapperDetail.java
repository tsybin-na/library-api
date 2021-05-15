package ru.tsybin.na.api.library.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Author;
import ru.tsybin.na.api.library.entity.Book;
import ru.tsybin.na.api.library.entity.Genre;
import ru.tsybin.na.api.library.exception.EntityNotFoundException;
import ru.tsybin.na.api.library.repository.AuthorRepository;
import ru.tsybin.na.api.library.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class BookMapperDetail implements BookMapper{

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    public abstract void toEntity(@MappingTarget Book book, BookDto bookDto);

    @AfterMapping
    public void toDtoAfterMapping(Book book, @MappingTarget BookDto bookDto) {
        List<Long> authorsIds = book.getAuthors().stream().map(Author::getId).collect(Collectors.toList());
        bookDto.setAuthorsIds(authorsIds);

        List<Long> genresIds = book.getGenres().stream().map(Genre::getId).collect(Collectors.toList());
        bookDto.setGenresIds(genresIds);
    }

    @AfterMapping
    public void toEntityAfterMapping(@MappingTarget Book book, BookDto bookDto) {
        List<Author> authors = book.getAuthors();
        authors.clear();
        bookDto.getAuthorsIds().forEach(authorId -> {
            Author author = authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("author not found, id: " + authorId));
            authors.add(author);
        });

        List<Genre> genres = book.getGenres();
        genres.clear();
        bookDto.getGenresIds().forEach(genreId -> {
            Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new EntityNotFoundException("genre not found, id: " + genreId));
            genres.add(genre);
        });
    }

}
