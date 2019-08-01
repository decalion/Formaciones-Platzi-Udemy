/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session37;

/**
 *
 * @author ismael
 */
public class EjemploForEach {
    
    public static void main(String[] args) {
        
        Persona[] personas = {new Persona("Ismael"), new Persona("Juan")};
        
        for (Persona persona : personas) {
            System.out.println("Nombre : " + persona.getNombre());
            
        }
                
    }
    
}
