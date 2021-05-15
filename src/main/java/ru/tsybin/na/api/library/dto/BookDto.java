package ru.tsybin.na.api.library.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookDto {
    Long id;

    @NotBlank(message = "{validation.name.empty}")
    String name;

    @NotBlank(message = "{validation.description.empty}")
    private String description;

    @NotEmpty(message = "{validation.authors.empty}")
    List<Long> authorsIds = new ArrayList<>();

    @NotEmpty(message = "{validation.genres.empty}")
    List<Long> genresIds = new ArrayList<>();

    public void addAuthorId(Long authorId) {
        authorsIds.add(authorId);
    }

    public void addGenreId(Long genreId) {
        genresIds.add(genreId);
    }

}
