-- 👤 Create a users table

CREATE TABLE users
(
    id             SERIAL PRIMARY KEY,
    full_name      varchar(50) NOT NULL,
    loyalty_points int DEFAULT 0
);