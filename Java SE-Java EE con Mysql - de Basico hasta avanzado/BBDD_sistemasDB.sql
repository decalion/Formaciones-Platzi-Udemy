CREATE DATABASE sistemaDB;

USE sistemaDB;


CREATE TABLE vacantes(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fecha_publicacion DATE,
nombre VARCHAR(250),
descripcion TEXT,
detalle TEXT
)ENGINE = InnoDB;

CREATE TABLE usuarios(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre VARCHAR(250),
email VARCHAR(100),
username VARCHAR(20),
password VARCHAR(50),
perfil VARCHAR(30),
estatus VARCHAR(20)
)ENGINE = InnoDB;