package com.icaballero.consultaparametros04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		String cadeConexion = "jdbc:mysql://localhost:3306/curso?useSSL=false";

		try (Connection conexion = DriverManager.getConnection(cadeConexion, "root", "ismael23");
				PreparedStatement sentencia = generarConsultaParametrizada("select * from persona where nombre=?", "pepe", conexion);
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
	
	
	
	
	/**
	 * Ejemplo de preparedStatement para hacer consultas paremetrizadas
	 * @param sql
	 * @param nombre
	 * @param conexion
	 * @return
	 * @throws SQLException
	 */
	private static PreparedStatement generarConsultaParametrizada(String sql,String nombre,Connection conexion) throws SQLException {
		
		PreparedStatement consultaParametrizada = conexion.prepareStatement(sql);
		consultaParametrizada.setString(1, nombre);
		
		return consultaParametrizada;
	}
	
	
	
	
	
	
	
	
	

}
