package com.icaballero.resultset03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		String cadeConexion = "jdbc:mysql://localhost:3306/curso?useSSL=false";

		try (Connection conexion = DriverManager.getConnection(cadeConexion, "root", "ismael23");
				Statement sentencia = conexion.createStatement();
				ResultSet rs = sentencia.executeQuery("select * from persona");
				) {

			//sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('juan','garcia',22)");

			/**
			 * Ejemplo de resultset y como mostrar los resultados
			 */
			
			while(rs.next()) {
				
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellidos"));
				System.out.println(rs.getString("edad"));
				System.out.println();
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
