package com.icaballero.transacciones06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		String cadeConexion = "jdbc:mysql://localhost:3306/curso?useSSL=false";

		
		/**
		 * Ejemplo de transaccion
		 */
		try (Connection conexion = DriverManager.getConnection(cadeConexion, "root", "ismael23");
				Statement sentencia = conexion.createStatement();) {
		
			//Esto hace que las consultas se ejecuten agrupadas y no 1 a 1
			conexion.setAutoCommit(false);
			
			//Se ejecuta de forma transaccional
			//si no se aacepta 1 insert el resto de insert no se añadiran a la BBDD 
			sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('juan9','garcia',22)");
			sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('juan10','garcia',22)");
			sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('juan11','garcia',22)");
			
			conexion.commit();
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
