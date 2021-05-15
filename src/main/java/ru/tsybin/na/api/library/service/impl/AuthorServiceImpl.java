package ru.tsybin.na.api.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsybin.na.api.library.dto.AuthorDto;
import ru.tsybin.na.api.library.mapper.AuthorMapper;
import ru.tsybin.na.api.library.repository.AuthorRepository;
import ru.tsybin.na.api.library.service.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDto> findAll() {
        return authorMapper.toDtoList(authorRepository.findAll());
    }

}
