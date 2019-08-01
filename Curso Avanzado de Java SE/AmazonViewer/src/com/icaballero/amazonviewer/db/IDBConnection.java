package com.icaballero.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.icaballero.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connecToDB(){
			Connection connection = null;
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+BD, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se establecio la conexion");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return connection;
		}
	}

}
