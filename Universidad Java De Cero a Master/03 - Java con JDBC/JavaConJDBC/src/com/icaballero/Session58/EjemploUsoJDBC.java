/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session58;

import java.util.List;

/**
 *
 * @author ismael
 */
public class EjemploUsoJDBC {
    
    public static void main(String[] args) {
        
        PersonaJDBC personaJDBC =  new PersonaJDBC();
        
       // personaJDBC.insert("Cristian", "Bautista");
        
      // personaJDBC.update(4, "Gerard", "Exposito");
       
      //personaJDBC.deleted(4);
        
      List<Persona> list = personaJDBC.select();
      
        for (Persona persona : list) {
            System.out.println(persona);
            
        }
    }

}
