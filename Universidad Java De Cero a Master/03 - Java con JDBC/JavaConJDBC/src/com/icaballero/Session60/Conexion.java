/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session60;

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
public class Conexion {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/sga?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "ismael23";
    private static Driver driver = null;
    
    public static synchronized Connection getConnection() throws SQLException{
        
        if(driver == null){
            try{
                
                Class classDriver = Class.forName(JDBC_DRIVER);
                driver = (Driver) classDriver.newInstance();
                DriverManager.registerDriver(driver);
                
            }catch(Exception e){
                System.out.println("Error al cargar el driver");
                e.printStackTrace();
            }
        }
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public static void close(PreparedStatement stmt) {

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public static void close(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
}
