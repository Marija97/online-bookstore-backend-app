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


--💸 Create a purchases table

CREATE TABLE purchases
(
    id      SERIAL PRIMARY KEY,
    user_id int   NOT NULL,
    CONSTRAINT fk_purchases_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    profit  float NOT NULL
);


-- 💸 + 📚 Create a join table for purchase-books relation

CREATE TABLE purchases_books
(
    purchase_id int NOT NULL,
    book_id     int NOT NULL,
    CONSTRAINT fk_purchase_books_purchase_id
        FOREIGN KEY (purchase_id)
            REFERENCES purchases (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT fk_purchase_books_book_id
        FOREIGN KEY (book_id)
            REFERENCES books (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);


-- 🛒 Create a Loyalty Points Discounts table

CREATE TABLE discounts
(
    id                  SERIAL PRIMARY KEY,
    book_type           varchar(3) NOT NULL
        CONSTRAINT check_book_type CHECK (book_type IN ('OLD', 'REG', 'NEW')),
    loyalty_points_cost int        NOT NULL
        CONSTRAINT loyalty_points_cost_range CHECK (loyalty_points_cost > 0),
    discount_percent    int        NOT NULL
        CONSTRAINT check_discount_percent_range CHECK (discount_percent > 0 AND discount_percent <= 100)
);

INSERT INTO discounts(book_type, loyalty_points_cost, discount_percent)
VALUES ('REG', 10, 100),
       ('OLD', 10, 100);


