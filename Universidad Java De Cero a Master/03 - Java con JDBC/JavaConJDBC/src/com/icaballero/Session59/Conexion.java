/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session59;


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
    private static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/sga?useSSL=false";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASS="ismael23";
    private static Driver driver = null;
    
    
    public static synchronized Connection getConnectio() throws SQLException{
        if(driver == null){
            try{
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
                
            }catch(Exception e){
                System.out.println("Fallo al cargar Driver JDBC");
                e.printStackTrace();
            }
            
            
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        
        try{
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }
    }
    
    
    
      public static void close(PreparedStatement stmt){
        
        try{
            if(stmt!=null){
                stmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }
    }
    
      
         public static void close(Connection con){
        
        try{
            if(con!=null){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }
    }
    
    
}
