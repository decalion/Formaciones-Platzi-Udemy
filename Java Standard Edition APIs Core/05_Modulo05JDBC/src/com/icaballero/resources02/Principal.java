package com.icaballero.resources02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		String cadeConexion = "jdbc:mysql://localhost:3306/curso?useSSL=false";

		// Ejemplo de try with resources disponible en java 7 o superior
		try (Connection conexion = DriverManager.getConnection(cadeConexion, "root", "ismael23");
				Statement sentencia = conexion.createStatement();) {
			/**
			 * A partir de Java 6 ya no es obligatorio registrar el driver
			 * 
			 * El metodo Try se encarga de crear y cerrar la conexion y el statment
			 * automaticamente
			 * 
			 */

			sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('juan','garcia',22)");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
