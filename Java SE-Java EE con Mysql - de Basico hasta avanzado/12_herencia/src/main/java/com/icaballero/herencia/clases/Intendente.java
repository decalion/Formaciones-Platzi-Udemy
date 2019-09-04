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
public class Intendente extends Persona {

    private String areaLimpieza;

    public Intendente() {
    }

    public Intendente(String areaLimpieza , String nombre, int edad, String sexo) {
        super(edad,nombre,sexo);
        this.areaLimpieza = areaLimpieza;

    }

    public void muestrInformacionDirector() {
        System.out.println("---INFORMACION DEL INTENDENTE----");
        System.out.println("Escuela : " + Persona.getNombreEscuela());
        System.out.println("Area : " + this.areaLimpieza);
        System.out.println("Nombre : " + this.getNombre());
        System.out.println("Edad : " + this.getEdad());
        System.out.println("Sexo : " + this.getSexo());
    }

    public String getArea() {
        return areaLimpieza;
    }

    public void setArea(String areaLimpieza) {
        this.areaLimpieza = areaLimpieza;
    }

}
