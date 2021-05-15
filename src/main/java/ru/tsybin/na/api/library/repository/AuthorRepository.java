package ru.tsybin.na.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsybin.na.api.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}