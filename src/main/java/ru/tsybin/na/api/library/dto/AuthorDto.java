package ru.tsybin.na.api.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthorDto {
    private UUID id;
    private String name;
}
