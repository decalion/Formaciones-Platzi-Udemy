/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.clases;

/**
 *
 * @author ismael
 */
public class Persona {
    
    
    /**
     * Atributos
     */
    
    private String nombre;
    private Integer edad;
    private String apellido;


    /**
     * Constructores
     */    
    
    public Persona() {
        this(null,0,null);
    }

    public Persona(String nombre, String apellido) {
        this(nombre,0,apellido);
//        this.nombre = nombre;
//        this.apellido = apellido;
    }
    
    public Persona(String nombre, Integer edad) {
        this(nombre,edad,null);
//        this.nombre = nombre;
//        this.edad = edad;
    }

    public Persona(String nombre, Integer edad, String apellido) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
    }
    
    
    
    /**
     * GETTERS/SETTERS
     */

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    
    
    
    
}
