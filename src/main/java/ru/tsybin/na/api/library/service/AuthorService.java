package ru.tsybin.na.api.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsybin.na.api.library.dto.AuthorDto;
import ru.tsybin.na.api.library.mapper.AuthorMapper;
import ru.tsybin.na.api.library.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Transactional(readOnly = true)
    public List<AuthorDto> findAll() {
        return authorMapper.toDtoList(authorRepository.findAll());
    }

}
