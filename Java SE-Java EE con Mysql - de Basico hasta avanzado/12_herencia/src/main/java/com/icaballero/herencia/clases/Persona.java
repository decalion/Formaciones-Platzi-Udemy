/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.herencia.clases;

/**
 *
 * @author ismael
 */
public class Persona {

    private static String nombreEscuela;
    private int edad;
    private String nombre;
    private String sexo;

    public Persona() {
    }

    public Persona(int edad, String nombre, String sexo) {
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public Persona(int edad, String nombre) {
        this(edad, nombre, null);
    }

    public Persona(String nombre) {
        this(0, nombre, null);
    }

    public static String getNombreEscuela() {
        return nombreEscuela;
    }

    public static void setNombreEscuela(String nombreEscuela) {
        Persona.nombreEscuela = nombreEscuela;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
