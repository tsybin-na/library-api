package ru.tsybin.na.api.library.mapper;

import org.mapstruct.Mapper;
import ru.tsybin.na.api.library.dto.AuthorDto;
import ru.tsybin.na.api.library.entity.Author;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

}
