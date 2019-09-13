package com.icaballero.procedures05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Principal {

	public static void main(String[] args) {

		String cadeConexion = "jdbc:mysql://localhost:3306/curso?useSSL=false";

		/**
		 * Ejemplo de ejecucion de un procedure
		 * con callablestatement
		 */
		try (Connection conexion = DriverManager.getConnection(cadeConexion, "root", "ismael23");
				CallableStatement sentencia = conexion.prepareCall("{CALL seleccionarPersonas()}");
				ResultSet rs = sentencia.executeQuery();
				) {


			
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
