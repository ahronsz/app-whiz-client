DROP TABLE IF EXISTS Clients;
DROP TABLE IF EXISTS Users;

CREATE TABLE Clients(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    mother_last_name VARCHAR(200) NOT NULL,
    paternal_last_name VARCHAR(200) NOT NULL,
    date_birth DATE NOT NULL,
    creation_date_time TIMESTAMP NOT NULL
);

CREATE TABLE Users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(500) NOT NULL,
    password VARCHAR(500) NOT NULL,
    creation_date_time TIMESTAMP NOT NULL
);