package ru.tsybin.na.api.library.service;

import ru.tsybin.na.api.library.dto.GenreDto;

import java.util.List;

public interface GenreService {

    List<GenreDto> findAll();

}
