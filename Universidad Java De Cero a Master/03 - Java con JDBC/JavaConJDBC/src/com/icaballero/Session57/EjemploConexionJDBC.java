/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session57;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ismael
 */
public class EjemploConexionJDBC {
    
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = (Connection) DriverManager.getConnection(url, "root", "ismael23");
            
            Statement instruccion = con.createStatement();
            
            String sql =" SELECT id_persona, nombre, apellido FROM persona";
            
            ResultSet result = instruccion.executeQuery(sql);
            
            while(result.next()){
                
                System.out.println("ID: " +result.getInt(1));
                System.out.println("Nombre: " +result.getString(2));
                System.out.println("Apellido: " +result.getString(3));
                System.out.println("---------------------");
                
            }
            
            result.close();
            instruccion.close();
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            
        }
    }
    
}
