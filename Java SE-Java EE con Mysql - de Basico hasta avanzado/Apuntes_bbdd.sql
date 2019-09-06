-- Comentario
# comentario

# CREAR BBDD si no existe
CREATE SCHEMA IF NOT EXISTS BdPendientes1;

# Usar una base de datos
USE BdPendientes1;

# Creando la tabla personas
CREATE TABLE IF NOT EXISTS Personas(
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    correo VARCHAR(30) NULL,
    telefono VARCHAR(30) NULL,
    PRIMARY KEY(id)
) ENGINE = InnoDB;


# Creando la tabla EstatusPendiente
CREATE TABLE IF NOT EXISTS EstatusPendiente(
	id INT NOT NULL AUTO_INCREMENT,
    estatus VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
) ENGINE = InnoDB;

# Creando la tabla Usuarios
CREATE TABLE IF NOT EXISTS Usuarios(
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    password VARCHAR(45) NOT NULL,
    idPersona INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FKUsuarioPersona
		FOREIGN KEY(idPersona)
        REFERENCES Personas(id)
) ENGINE = InnoDB;

# Creando la tabla Pendientes
CREATE TABLE IF NOT EXISTS Pendientes(
	id INT NOT NULL AUTO_INCREMENT,
    fechaCreacion DATETIME NOT NULL,
    fechaEntega DATETIME NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    idEstatusPendiente INT NOT NULL,
    onservaciones VARCHAR(250) NOT NULL,
    idPersonaQueAsigno INT NOT NULL,
    idPersonaAsignado INT NOT NULL,
    solucionPendiente VARCHAR(250),
    PRIMARY KEY(id),
    CONSTRAINT FKPendEstatus
		FOREIGN KEY(idEstatusPendiente)
        REFERENCES EstatusPendiente(id),
        
	CONSTRAINT FKPersonaAsignadoPersona
		FOREIGN KEY(idPersonaQueAsigno)
        REFERENCES Personas(id),
        
	CONSTRAINT FKPersonaAsignadoPerson
		FOREIGN KEY(idPersonaAsignado)
        REFERENCES Personas(id)
) ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS TipoIngEg(
	id INT NOT NULL,
    descripcion VARCHAR(20),
    PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS GrupoIngEg(
	id INT NOT NULL,
    descripcion VARCHAR(20),
    observaciones VARCHAR(50),
    PRIMARY KEY(id)
) ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS IngresosEgresos(
	id INT NOT NULL,
    descripcion VARCHAR(30),
    idTipoIngEg INT NOT NULL,
    idGrupoIngEg INT NOT NULL,
    observaciones VARCHAR(50),
    PRIMARY KEY(id),
	CONSTRAINT FKtipoingeg
		FOREIGN KEY(idTipoIngEg)
        REFERENCES TipoIngEg(id),
        
	CONSTRAINT FKgrupoIngEg
		FOREIGN KEY(idGrupoIngEg)
        REFERENCES GrupoIngEg(id)
) ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS EntradSalidaDinero(
	id INT NOT NULL AUTO_INCREMENT,
    fechaEs DATE NOT NULL,
    idTipoIngEg INT NOT NULL,
    montoIE decimal(6,0) NOT NULL,
	idPersonaQueRegistro INT NOT NULL,
    observaciones VARCHAR(50),
    PRIMARY KEY(id),
	CONSTRAINT FKingresoegreso
		FOREIGN KEY(idTipoIngEg)
        REFERENCES IngresosEgresos(id),
        
	CONSTRAINT FKidpersonas
		FOREIGN KEY(idPersonaQueRegistro)
        REFERENCES Personas(id)
) ENGINE = InnoDB;



# VER INFORMACION DE UNA TABLA
DESC entradsalidadinero;

#MODIFICAR DATO DE UNA TABLA
ALTER TABLE entradsalidadinero
MODIFY COLUMN montoie VARCHAR(30);

#Añadir una columna a una tabla
ALTER TABLE entradsalidadinero
ADD COLUMN temporal VARCHAR(30);

# CAMBIAR EL NOMBRE DE UNA TABLA
RENAME TABLE personas to persona;


# ELIMINAR UNA TABLA
DROP TABLE EstatusPendiente;

# ELIMINAR LOS REGISTROS DE UNA TABLA
TRUNCATE TABLE EstatusPendiente;



# CONSULTAS

SELECT * FROM usuarios;

SELECT * FROM usuarios
ORDER BY nombre;

SELECT nombre,password FROM usuarios
ORDER BY nombre DESC;


SELECT fechaEs, idTipoIngEg, montoie , montoie *2 as MULTIPLICADOR
FROM entradsalidadinero
WHERE idTipoIngEg=34 AND (fechaES BETWEEN '2018-01-01' AND '2018-01-31')
ORDER BY multiplicador desc;


SELECT DISTINCT idTipoIngEg, montoie
FROM entradsalidadinero;


SELECT DISTINCT concat(idTipoIngEg,'-',montoie)
FROM entradsalidadinero;

SELECT DISTINCT concat(' ID= ',idTipoIngEg,' MONTO= ',montoie)
FROM entradsalidadinero;

SELECT DISTINCT concat(' ID= ',idTipoIngEg,' MONTO= ',montoie, ' CON FECHA=' ,fechaEs)
FROM entradsalidadinero;

SELECT DISTINCT concat(' ID= ',idTipoIngEg,' MONTO= ',montoie, ' CON FECHA=' ,DATE_FORMAT(fechaEs,'%d/%m/%y')) 
FROM entradsalidadinero;

SELECT DISTINCT concat(' ID= ',idTipoIngEg,' MONTO= ',montoie, ' CON FECHA=' ,DATE_FORMAT(fechaEs,'%d/%m/%Y')) AS SALIDA
FROM entradsalidadinero;


SELECT *
FROM entradsalidadinero
WHERE montoie < 1000;

SELECT *
FROM entradsalidadinero
WHERE montoie BETWEEN 1000 AND 3000;

# QUE NO SEA IGUAL A 2000
SELECT *
FROM entradsalidadinero
WHERE montoie <> 2000;

#FECHA MENOR AL DIA ACTUAL
SELECT *
FROM entradsalidadinero
WHERE fechaEs < curdate();


#SACAR los telefonos que empiezan por 493 o 492
SELECT *
FROM personas
WHERE LEFT(telefono,3)='493' OR LEFT(telefono,3)='492';


#SACAR los telefonos que NO empiezan por 493 o 492
SELECT *
FROM personas
WHERE NOT(LEFT(telefono,3)='493' OR LEFT(telefono,3)='492');

SELECT *
FROM personas
WHERE LEFT(telefono,3) IN ('492','493');


SELECT *
FROM personas
WHERE LEFT(telefono,3)  NOT IN ('492','493');


SELECT *
FROM personas
WHERE nombre IN (SELECT nombre FROM personas
WHERE length(nombre)<=4);


SELECT *
FROM personas
WHERE LEFT(telefono,3)='493' AND correo LIKE('%hotmail%');


SELECT *
FROM personas
WHERE correo LIKE('%hotmail%')
ORDER BY nombre,telefono
LIMIT 3;

SELECT entradsalidadinero.idtipoingeg, entradsalidadinero.montoie, entradsalidadinero.fechaEs,personas.nombre
FROM  entradsalidadinero INNER JOIN personas ON(entradsalidadinero.idpersonaqueregistro = personas.id);


# HACER UNA COPIA DE OTRA TABLA
CREATE TABLE  tmpPersonas AS SELECT * FROM personas;

#ELIMINAR UNA TABLA
DROP TABLE TMPPERSONAS;

#CREAR LA TABLA SIN DATOS
CREATE TABLE  tmpPersonas AS SELECT * FROM personas
WHERE id = -1;

#INSERTAR DATOS
INSERT INTO tmpPersonas VALUES(0,'ismael','icaballero@correo.com','987654321');

INSERT INTO tmpPersonas VALUES
(1,'PEPE','icaballero@correo.com','987654321'),
(2,'JUAN','icaballero@correo.com','987654321'),
(3,'CRISTIAN','icaballero@correo.com','987654321');



#EJEMPLO UPDATE
UPDATE tmpPersonas 
SET nombre='David' 
WHERE id=1;


#Ejemplo DELETE
DELETE FROM tmpPersonas WHERE id = 3;

#VER PERMISOS DEL USUARIO
SHOW PRIVILEGES;

#Ver usuarios dados de alta
SELECT user,host from mysql.user;


#CREAR VISTAS
CREATE VIEW personasview as
SELECT nombre,correo from personas;

#Modificar una vista
CREATE OR REPLACE VIEW personasview as
SELECT nombre,correo,telefono from personas;

SELECT * FROM personasview;


# Procedimientos

DELIMITER //
CREATE PROCEDURE prueba()
BEGIN
	SELECT 'ESTO ES UNA PRUEBA' AS mimensaje;
END //
DELIMITER ;


#LLamar a un procedimiento
call prueba();

#Eliminar un procedure
drop procedure prueba;


DELIMITER //
CREATE PROCEDURE prueba()
BEGIN
	SELECT 'ESTO ES UNA PRUEBA' AS mimensaje,
			'Segundo Mensaje' AS mimensaje2,
			'Tercer Mensaje' AS mimensaje3;
END //
DELIMITER ;

call prueba();



DELIMITER //
CREATE PROCEDURE prueba()
BEGIN
	DECLARE nuevos int;
    DECLARE finalizados int;
    DECLARE leidos int;
    
	SELECT COUNT(*)
    INTO nuevos
    FROM bdpendientes1.pendientes INNER JOIN
    estatuspendiente ON estatuspendiente.id = pendientes.idEstatusPendiente
    WHERE estatuspendiente.estatus = 'NUEVO';
    
	SELECT COUNT(*)
    INTO finalizados
    FROM bdpendientes1.pendientes INNER JOIN
    estatuspendiente ON estatuspendiente.id = pendientes.idEstatusPendiente
    WHERE estatuspendiente.estatus = 'FINALIZADO';
    
    SELECT COUNT(*)
    INTO leidos
    FROM bdpendientes1.pendientes INNER JOIN
    estatuspendiente ON estatuspendiente.id = pendientes.idEstatusPendiente
    WHERE estatuspendiente.estatus = 'LEIDO';
    
    
    SELECT nuevos AS pendientesNuevos,
		finalizados AS pendientesFinalizados,
        leidos AS pendientesLeidos;
END //
DELIMITER ;

call prueba();


-- -------------------------------------------------------------------

drop procedure totalpendientes;

DELIMITER //
CREATE PROCEDURE totalpendientes(IN varIdPersonaAsignado INT, OUT frase VARCHAR(50), OUT persona VARCHAR(50))
BEGIN
	DECLARE totalpendientes int;
    
    SELECT count(*)
    INTO totalpendientes
    FROM pendientes
    WHERE idPersonaAsignado=varIdPersonaAsignado;
    
    SELECT nombre
    INTO persona
    FROM personas
    WHERE id=varIdPersonaAsignado;
    
    if totalpendientes=0 then
		set frase='NO TIENE PENDIENTES';
	elseif totalpendientes>1 AND totalpendientes<3 then
		set frase=CONCAT('ESTA ALGO OCUPADO',totalpendientes, ' PENDIENTES');
	elseif totalpendientes>=4 THEN
		set frase=CONCAT('TIENE MUCHO TRABAJO',totalpendientes, ' PENDIENTES');
	end if;

END //
DELIMITER ;

call totalpendientes(2,@frase,@persona);

SELECT @frase,@persona;




# EJEMPLO WHILE
DROP PROCEDURE usoWhile;

DELIMITER //
CREATE PROCEDURE usoWhile()
BEGIN
	DECLARE cont INT DEFAULT 1;
    DECLARE s VARCHAR(100) DEFAULT '';
    
    WHILE cont<=5 DO
    
		SET s = concat(S,' cont= ',cont,'|');
		
		SET cont=cont+1;
    END WHILE;

	SELECT s as mensaje;
END //
DELIMITER ;

call usoWhile();



#EJEMPLO REPEAT
DROP PROCEDURE usoRepeat;

DELIMITER //
CREATE PROCEDURE usoRepeat()
BEGIN
	DECLARE cont INT DEFAULT 1;
    DECLARE s VARCHAR(100) DEFAULT '';
    
    REPEAT
    
		SET s = concat(S,' cont= ',cont,'|');
		SET cont=cont+1;
        
     UNTIL cont = 5   
   END REPEAT;

	SELECT s as mensaje;
END //
DELIMITER ;

call usoRepeat();


#EJEMPLO LOOP
DROP PROCEDURE usoLoop;

DELIMITER //
CREATE PROCEDURE usoLoop()
BEGIN
	DECLARE cont INT DEFAULT 1;
    DECLARE s VARCHAR(100) DEFAULT '';
    DECLARE testLoop VARCHAR(10);
    
    testLoop : LOOP
    
		SET s = concat(S,' cont= ',cont,'|');
		SET cont=cont+1;
        
        IF i=4 THEN
			LEAVE testLoop;
        END IF;
        
	END LOOP testLoop;
    

	SELECT s as mensaje;
END //
DELIMITER ;

call usoLoop();



#EJEMPLO DE CASE

drop procedure totalpendientesCASE;

DELIMITER //
CREATE PROCEDURE totalpendientesCASE(IN varIdPersonaAsignado INT, OUT frase VARCHAR(50), OUT persona VARCHAR(50))
BEGIN
	DECLARE totalpendientes int;
    
    SELECT count(*)
    INTO totalpendientes
    FROM pendientes
    WHERE idPersonaAsignado=varIdPersonaAsignado;
    
    SELECT nombre
    INTO persona
    FROM personas
    WHERE id=varIdPersonaAsignado;
    
    CASE totalpendientes
		WHEN totalpendientes>=1 AND totalpendientes<=3 THEN
			set frase=CONCAT('ESTA ALGO OCUPADO',totalpendientes, ' PENDIENTES');
		WHEN totalpendientes>=4 THEN
			set frase=CONCAT('TIENE MUCHO TRABAJO',totalpendientes, ' PENDIENTES');
		ELSE
			set frase='NO TIENE PENDIENTES';
    END CASE;

END //
DELIMITER ;

call totalpendientesCASE(3,@frase,@persona);

SELECT @frase,@persona;


#CURSORES

drop procedure cursores;

DELIMITER //
CREATE PROCEDURE cursores()
BEGIN
	DECLARE id_persona_var INT;
    DECLARE telefono_var VARCHAR(30);
    DECLARE row_not_found TINYINT DEFAULT false;
    DECLARE update_count INT DEFAULT 0;

	-- declarar cursor
    DECLARE id_persona_cursor CURSOR FOR
    SELECT id,telefono FROM personas
    WHERE correo LIKE '%hotmail%';
    
    
    -- control de errores si no hay registros
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET row_not_found = true;
    
    -- ABRIR EL CURSOS
    OPEN id_persona_cursor;
    WHILE row_not_found = false DO
		-- OBTENER LOS VALORES
        FETCH id_persona_cursor INTO id_persona_var , telefono_var;
        
        IF length(telefono_var) > 0 THEN
        
			UPDATE pendientes
            SET onservaciones = telefono_var
            WHERE id=id_persona_var;
            
		ELSE
			UPDATE pendientes
            SET onservaciones = 'SOLICITAR NUMERO DE TELEFONO'
            WHERE id=id_persona_var;
            
            SET update_count=update_count+1;
        END IF;
    
    END WHILE;

	-- CERRAR CURSOR
	CLOSE id_persona_cursor;
    
    SELECT CONCAT(update_count,' NECESITAN TELEFONO');

END //
DELIMITER ;


call cursores;



#Transaciones

drop procedure transacciones;

DELIMITER //
CREATE PROCEDURE transacciones()
BEGIN
	DECLARE sql_error TINYINT DEFAULT false;
    
    DECLARE CONTINUE HANDLER FOR sqlexception
		SET	 sql_error = TRUE;

	start transaction;
		-- insert
        -- delete
        -- update

    if sql_error = false then
		commit;
        SELECT 'La ttransacion se ejecuto correctamente';
	else
		rollback;
		SELECT 'Error al realizar la transaccion';
    END IF;

END //
DELIMITER ;


call cursores;




