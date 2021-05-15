package ru.tsybin.na.api.library.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsybin.na.api.library.dto.GenreDto;
import ru.tsybin.na.api.library.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("api/genres")
    List<GenreDto> findAll() {
        return genreService.findAll();
    }

}
