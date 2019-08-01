/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session58;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismael
 */
public class PersonaJDBC {
    
    private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER BY id_persona";
    
    
    public int insert(String nombre , String apellido){
        Connection con = null;
        PreparedStatement stmt = null;
        
        int rows = 0;
        
        try{
            con = Conexion.getConnectio();
            stmt = con.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            System.out.println("Ejecutando Query " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados: "+rows);
        
         }catch(SQLException e){
             e.printStackTrace();
         }finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
        
    }
    
    public int update(int id_persona, String nombre, String apellido){
        Connection con = null;
        PreparedStatement stmt = null;
       
        
        int rows = 0;
        
        try{
            con = Conexion.getConnectio();
            stmt = con.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            
            stmt.setInt(index, id_persona);
            System.out.println("Ejecutando la query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
                    
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(con);
            Conexion.close(stmt);
        }
        
        
        return rows;
    }
    
    public int deleted(int id_persona){
        Connection con = null;
        PreparedStatement stmt = null;
        
        int rows = 0;
        
        try{
            con = Conexion.getConnectio();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_persona);
            
            System.out.println("Ejecutando la query: " + SQL_DELETE);
            
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados : " + rows);
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(con);
            Conexion.close(stmt);
        }
        
        return rows;
    }
    
    
    public List<Persona> select(){
        List<Persona> lista = new ArrayList<>();
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        try{
            con = Conexion.getConnectio();
            stmt = con.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                persona = new Persona();
                persona.setId_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                
                lista.add(persona);
                
            }
            
        }catch(SQLException e){
            
        }finally{
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        
        return lista;
        
        
    }
    
    
    
}
