CREATE TABLE Person
(
    id          SERIAL PRIMARY KEY,
    FirstName   VARCHAR(50) NOT NULL,
    LastName    VARCHAR(50) NOT NULL,
    age         INT,
    Gender      CHAR(1) CHECK (Gender IN ('M', 'F', 'O')),
    Email       VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(15)
);
