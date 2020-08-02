CREATE DATABASE springboot;

use springboot;

CREATE TABLE Persona(
nombre VARCHAR(25) PRIMARY KEY,
apellidos VARCHAR(25),
edad int
);

INSERT INTO persona VALUES('pepe','perez',30);
INSERT INTO persona VALUES('ana','sanchez',30);