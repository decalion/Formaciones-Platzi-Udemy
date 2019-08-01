/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.dao;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ismael
 */
public class DBConnection {
  
   private static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/sga?useSSL=false";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASS="ismael23";
    private static Driver driver = null;

    /**
     * Metodo pra obtener la conexion
     *
     * @return
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {

        if (driver == null) {
            try {
                Class jdbcDriver = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriver.newInstance();
                DriverManager.registerDriver(driver);

            } catch (Exception e) {
                throw new SQLException("Error al crear la conexion");
            }

        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

    }

    /**
     * Metodo para cerrar la conexion
     *
     * @param con
     */
    public static void close(Connection con) {

        try {
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para cerrar el preparedStatment
     *
     * @param stmt
     */
    public static void close(PreparedStatement stmt) {

        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para cerrar el resultSet
     *
     * @param rs
     */
    public static void close(ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
