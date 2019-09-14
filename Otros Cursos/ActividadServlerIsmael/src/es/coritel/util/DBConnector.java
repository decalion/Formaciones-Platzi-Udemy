package es.coritel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class DBConnector {

	private static Connection con = null;
	private static final String URL = "jdbc:mysql://localhost/techsupport2";
	private static final String USER = "root";
	private static final String PASS = "abcd1234";

	private DBConnector() {

	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public static void closeConnection(Connection conn) throws Exception {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	public static void closeStatement(PreparedStatement ps) throws Exception {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar el PreparedStatment");
		}
	}


	public static void closeResulSet(ResultSet rs) throws Exception {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar el resultSet");
		}

	}

}
