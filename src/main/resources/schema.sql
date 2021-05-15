DROP TABLE IF EXISTS genres;

CREATE TABLE genres
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS authors;

CREATE TABLE authors
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS books;

CREATE TABLE books
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250)  NOT NULL,
    description VARCHAR(4000) NOT NULL
);

DROP TABLE IF EXISTS books_authors;

CREATE TABLE books_authors
(
    book_id   BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    CONSTRAINT fk_books_authors_book_id
        FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT fk_books_authors_author_id
        FOREIGN KEY (author_id) REFERENCES authors (id)
);

DROP TABLE IF EXISTS books_genres;

CREATE TABLE books_genres
(
    book_id  BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, genre_id),
    CONSTRAINT fk_books_genres_book_id
        FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT fk_books_genres_genre_id
        FOREIGN KEY (genre_id) REFERENCES genres (id)
);