package ru.tsybin.na.api.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tsybin.na.api.library.dto.BookDto;
import ru.tsybin.na.api.library.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    BookDto toDto(Book book);

    List<BookDto> toDtoList(List<Book> books);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Book toEntity(BookDto bookDto);

}
