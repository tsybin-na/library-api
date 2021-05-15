INSERT INTO genres (name) VALUES('фантастика');
INSERT INTO genres (name) VALUES('ужасы');
INSERT INTO genres (name) VALUES('триллеры');

INSERT INTO authors (name) VALUES('Дэниел Киз');
INSERT INTO authors (name) VALUES('Мариам Петросян');
INSERT INTO authors (name) VALUES('Чак Паланик');

insert into books (name, description) values ('книга1', 'описание книги 1');
insert into books_authors (book_id, author_id) values (1, 1);
insert into books_genres (book_id, genre_id) values (1, 1);