/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session60;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ismael
 */
public class EjemploCapaDatos {
    
    public static void main(String[] args)  {
        
        PersonaDao personaDao = new PersonaDaoJDBC();
        
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("nombre de prueba");
        persona.setApellido("Apellido de prueba");
        
        PersonaDTO persona2 = new PersonaDTO(5);
        
        try{
            //personaDao.insert(persona);
           // personaDao.delete(persona2);
            List<PersonaDTO> lista = personaDao.select();
            
            for (PersonaDTO personaDTO : lista) {
                System.out.println(personaDTO);
                
            }
        }catch(SQLException e){
            
        }
        
    }
    
}
