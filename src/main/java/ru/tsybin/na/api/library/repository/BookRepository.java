package ru.tsybin.na.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsybin.na.api.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}