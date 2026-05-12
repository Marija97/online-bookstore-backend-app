-- 👤 Create a users table

CREATE TABLE users
(
    id             SERIAL PRIMARY KEY,
    full_name      varchar(50) NOT NULL,
    loyalty_points int DEFAULT 0
);


-- 📚 Create a books table with some inventory

CREATE TABLE books
(
    id         SERIAL PRIMARY KEY,
    title      varchar(200) NOT NULL,
    type       varchar(3),
    CONSTRAINT check_book_type CHECK (type IN ('OLD', 'REG', 'NEW')),
    base_price float        NOT NULL,
    quantity   int          NOT NULL
);

INSERT INTO books(title, type, base_price, quantity)
VALUES ('Crime and Punishment', 'OLD', 7.89, 34),
       ('The Alchemist', 'REG', 6.07, 113),
       ('1984', 'NEW', 12.50, 78),
       ('To Kill a Mockingbird', 'REG', 9.99, 45),
       ('Moby Dick', 'OLD', 5.25, 21),
       ('The Great Gatsby', 'REG', 8.40, 67),
       ('War and Peace', 'OLD', 11.15, 12),
       ('Brave New World', 'NEW', 13.30, 54),
       ('The Catcher in the Rye', 'REG', 7.75, 39),
       ('Pride and Prejudice', 'OLD', 6.80, 88),
       ('The Hobbit', 'NEW', 14.99, 102),
       ('Fahrenheit 451', 'REG', 10.20, 49);

