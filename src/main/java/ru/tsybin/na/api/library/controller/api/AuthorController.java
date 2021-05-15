package ru.tsybin.na.api.library.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsybin.na.api.library.dto.AuthorDto;
import ru.tsybin.na.api.library.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("api/authors")
    List<AuthorDto> findAll() {
        return authorService.findAll();
    }

}
