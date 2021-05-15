package ru.tsybin.na.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsybin.na.api.library.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}