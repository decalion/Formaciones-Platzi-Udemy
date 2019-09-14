package com.icaballero.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icaballero.exceptions.DAOException;

/**
 * HELPER class to handle DATACONNECTIVITY with FESTIVALDATABASE in MYSQL
 */
public class FERSDataConnection {

	// private static Connection conn;
	private final static String URL = "jdbc:mysql://localhost/festivaldb";
	private final static String USER = "root";
	private final static String PASS = "abcd1234";

	/**
	 * Get connection
	 * 
	 * @return
	 * @throws DAOException
	 */
	public static Connection getConnection() throws DAOException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false);

		} catch (Exception e) {
			throw new DAOException("Error al crear la conexion");
		}

		return conn;
	}

	/**
	 * Close connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void closeConnection(Connection conn) throws DAOException {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new DAOException("Error al cerrar la conexion");
		}
	}

	/**
	 * Commit connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void commit(Connection conn) throws DAOException {
		try {
			if (conn != null) {
				conn.commit();
			}

		} catch (Exception e) {
			throw new DAOException("Error al hacer el commit");
		}
	}

	/**
	 * Rollback connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void rollback(Connection conn) throws DAOException {

		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			throw new DAOException("Error al hacer rollback");
		}
	}

	/**
	 * Close preparedStatement
	 * 
	 * @param ps
	 * @throws DAOException
	 */
	public static void closeStatement(PreparedStatement ps) throws DAOException {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			throw new DAOException("Error al cerrar el PreparedStatment");
		}
	}

	/**
	 * Close preparedStatement
	 * 
	 * @param rs
	 * @throws DAOException
	 */
	public static void closeResulSet(ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new DAOException("Error al cerrar el resultSet");
		}

	}
}
