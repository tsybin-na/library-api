package ru.tsybin.na.api.library.dto;

import lombok.Getter;
import lombok.Setter;
import ru.tsybin.na.api.library.enumeration.GenreEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BookDto {
    private UUID id;

    private OffsetDateTime createdAt;

    @NotBlank(message = "{validation.name.empty}")
    String name;

    @NotBlank(message = "{validation.description.empty}")
    private String description;

    @NotNull(message = "{validation.genre.empty}")
    private GenreEnum genre;

    private Boolean bestseller = Boolean.FALSE;

    private Integer minimumOnDisplay = 0;

    @NotEmpty(message = "{validation.authors.empty}")
    private List<UUID> authorsIds = new ArrayList<>();

    public void addAuthorId(UUID authorId) {
        authorsIds.add(authorId);
    }

}
