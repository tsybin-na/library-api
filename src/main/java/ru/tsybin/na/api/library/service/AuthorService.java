package ru.tsybin.na.api.library.service;

import ru.tsybin.na.api.library.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> findAll();

}
