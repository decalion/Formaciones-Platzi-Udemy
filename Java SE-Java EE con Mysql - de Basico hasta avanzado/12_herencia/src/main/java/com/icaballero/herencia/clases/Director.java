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
public class Director extends Persona {

    private String claveSector;

    public Director() {
    }

    public Director(String claveSector, String nombre, int edad, String sexo) {
        super(edad, nombre, sexo);
        this.claveSector = claveSector;
    }

    public void muestrInformacionDirector() {
        System.out.println("---INFORMACION DEL DIRECTOR----");
        System.out.println("Escuela : " + Persona.getNombreEscuela());
        System.out.println("Clave del sector : " + this.claveSector);
        System.out.println("Nombre : " + this.getNombre());
        System.out.println("Edad : " + this.getEdad());
        System.out.println("Sexo : " + this.getSexo());
    }

    public String getClaveSector() {
        return claveSector;
    }

    public void setClaveSector(String claveSector) {
        this.claveSector = claveSector;
    }

}
