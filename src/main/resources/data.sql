CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    publication_year INT,
    rating INT
);


INSERT INTO book (title, author, publication_year, rating) VALUES ('Book One', 'Author A', 2020, 4);
INSERT INTO book (title, author, publication_year, rating) VALUES ('Book Two', 'Author B', 2021, 3);
INSERT INTO book (title, author, publication_year, rating) VALUES ('Book Three', 'Author A', 2019, 4);