/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.herencia.clases.test;

import com.icaballero.herencia.clases.Alumno;
import com.icaballero.herencia.clases.Director;
import com.icaballero.herencia.clases.Persona;

/**
 *
 * @author ismael
 */
public class Principal {
    
    public static void main(String[] args) {
        Persona.setNombreEscuela("IES Nicolau Copernic");
        
        Alumno alumno = new Alumno(1000, "Ismael", 23, "Masculino");
        alumno.muestrInformacionAlumno();
        
        Director director = new Director("1111", "Juan Luis", 55, "Masculino");
        director.muestrInformacionDirector();
        
    }
    
}
