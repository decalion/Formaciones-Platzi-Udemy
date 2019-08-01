/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session59;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ismael
 */
public class EjemploTranssaciones {
    
    public static void main(String[] args) {
        
        PersonaJDBC personaJDBC = new PersonaJDBC();
        Connection con = null;
        
        try {

            con = Conexion.getConnectio();
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }

            PersonaJDBC persona = new PersonaJDBC(con);

            persona.insert("agustin", "adfafafafadfacdadcassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

            con.commit();
        } catch (SQLException e) {
            try {
                System.out.println("Entramos al rollback");
                e.printStackTrace(System.out);
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);

            }
        }
    }
        
       // personaJDBC.insert("Cristian", "Bautista");
        
      // personaJDBC.update(4, "Gerard", "Exposito");
       
      //personaJDBC.deleted(4);
   /*     
      List<Persona> list = personaJDBC.select();
      
        for (Persona persona : list) {
            System.out.println(persona);
            
        }*/
 }

