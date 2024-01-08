package ru.tsybin.na.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsybin.na.api.library.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

}