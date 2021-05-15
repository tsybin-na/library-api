package ru.tsybin.na.api.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsybin.na.api.library.dto.GenreDto;
import ru.tsybin.na.api.library.mapper.GenreMapper;
import ru.tsybin.na.api.library.repository.GenreRepository;
import ru.tsybin.na.api.library.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final GenreMapper genreMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> findAll() {
        return genreMapper.toDtoList(genreRepository.findAll());
    }

}
