CREATE TABLE IF NOT EXISTS Book (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    quantity INTEGER NOT NULL,
    author VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL
);