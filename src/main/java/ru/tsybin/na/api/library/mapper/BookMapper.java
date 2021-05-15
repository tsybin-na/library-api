package ru.tsybin.na.api.library.mapper;

import org.mapstruct.Mapper;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    BookDto toDto(Book book);

    List<BookDto> toDtoList(List<Book> books);

    Book toEntity(BookDto bookDto);

}
