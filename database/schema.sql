CREATE TABLE games (
    identifier TEXT PRIMARY KEY,
    title TEXT NOT NULL,
    release_day INTEGER NOT NULL,
    release_month INTEGER NOT NULL,
    release_year INTEGER NOT NULL,
    price_euros INTEGER NOT NULL,
    price_cents INTEGER NOT NULL
);