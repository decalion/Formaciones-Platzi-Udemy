package com.icaballero.insert01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			//Registramos el driver de mysql
			//Se pueden tener mas driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Cadena de conexion de la base de datos
			String cadeConexion="jdbc:mysql://localhost:3306/curso?useSSL=false";
			
			
			//Obtenemos la conexion a travez del driver con los datos de la bbdd
			Connection conexion=DriverManager.getConnection(cadeConexion,"root","ismael23");
			
			//insert
			Statement sentencia=conexion.createStatement();
			sentencia.executeUpdate("insert into persona(nombre,apellidos,edad) values('pepe','perez',20)");
			
			//Cerrar los recursos
			sentencia.close();
			conexion.close();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		
		
		
		

	}

}
