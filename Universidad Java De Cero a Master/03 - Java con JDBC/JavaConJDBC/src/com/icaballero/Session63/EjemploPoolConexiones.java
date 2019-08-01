/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session63;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ismael
 */
public class EjemploPoolConexiones {
    
    
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = PoolConexionesMysql.getConnection();
            System.out.println("Utilizamos el pool de conexiones de Mysql");
            stmt = con.prepareStatement("SELECT * FROM persona");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println("ID : " + rs.getInt(1));
                System.out.println("NOMBRE : " + rs.getString(2));
                System.out.println("Apellido : " + rs.getString(3));
                System.out.println();
            }
            con.close();
            
            
            con = PoolConexionesOracle.getConnection();
            System.out.println("Utilizamos el pool de conexiones de ORACLE");
            stmt = con.prepareStatement("SELECT * FROM employees WHERE employee_id IN(100,101,102)");
            rs = stmt.executeQuery();
            
              while(rs.next()){
                System.out.println("ID : " + rs.getInt(1));
                System.out.println("NOMBRE : " + rs.getString(2));
                System.out.println("Apellido : " + rs.getString(3));
                System.out.println();
            }
            con.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
