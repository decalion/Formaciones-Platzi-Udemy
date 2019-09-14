CREATE DATABASE curso;

USE curso;

CREATE TABLE Persona(
nombre VARCHAR(20) PRIMARY KEY,
apellidos VARCHAR(20),
edad int
);

SELECT * FROM persona;


DELIMITER //
CREATE PROCEDURE seleccionarPersonas()
	BEGIN
		SELECT * FROM persona;
	END //
DELIMITER ;

call seleccionarPersonas;