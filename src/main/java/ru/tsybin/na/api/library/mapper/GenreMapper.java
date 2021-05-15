package ru.tsybin.na.api.library.mapper;

import org.mapstruct.Mapper;
import ru.tsybin.na.api.library.dto.GenreDto;
import ru.tsybin.na.api.library.entity.Genre;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreDto toDto(Genre genre);

    List<GenreDto> toDtoList(List<Genre> genres);

}
