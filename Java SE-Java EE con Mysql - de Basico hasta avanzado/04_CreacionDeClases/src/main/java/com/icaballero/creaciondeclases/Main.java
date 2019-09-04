/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.creaciondeclases;

/**
 *
 * @author ismael
 */
public class Main {
    
    public static void main(String[] args) {
        
        Persona p1 = new Persona("Ismael", "Caballero", 30, "Masculino");
        
        System.out.println(p1.getNombre());
        System.out.println(p1.getApellido());
        System.out.println(p1.getEdad());
        System.out.println(p1.getGenero());
        
    }
    
}
