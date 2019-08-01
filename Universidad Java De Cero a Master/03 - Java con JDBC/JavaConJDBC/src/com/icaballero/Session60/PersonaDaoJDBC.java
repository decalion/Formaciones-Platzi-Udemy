/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session60;

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
public class PersonaDaoJDBC implements PersonaDao {
    
    private Connection con;
    private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER BY id_persona";

    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection con) {
        this.con = con;
    }
    
    

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = (this.con != null) ? this.con : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Se han insertado: " + rows);
        } finally {
            Conexion.close(stmt);
            if (this.con == null) {
                Conexion.close(con);
            }

        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = (this.con != null) ? this.con : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } finally {
            Conexion.close(stmt);
            if (this.con == null) {
                Conexion.close(con);
            }

        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = (this.con != null) ? this.con : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            System.out.println("Ejecutando query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } finally {
            Conexion.close(stmt);
            if (this.con == null) {
                Conexion.close(con);
            }

        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();

        try {
            con = (this.con != null) ? this.con : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                persona = new PersonaDTO();
                persona.setId_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                
                personas.add(persona);
                
            }
            
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.con == null) {
                Conexion.close(con);
            }

        }
        return personas;
    }
    
}
