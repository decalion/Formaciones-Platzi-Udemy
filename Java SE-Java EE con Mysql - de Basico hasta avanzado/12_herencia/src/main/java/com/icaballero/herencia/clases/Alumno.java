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
public class Alumno extends Persona {

    private int numeroAlumno;

    public Alumno() {
    }

    public Alumno(int numeroAlumno, String nombre, int edad, String sexo) {
        this.numeroAlumno = numeroAlumno;
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setSexo(sexo);
    }

    public void muestrInformacionAlumno() {
        System.out.println("---INFORMACION DEL ALUMNO----");
        System.out.println("Escuela : " + Persona.getNombreEscuela());
        System.out.println("Numero del alumno : " + this.numeroAlumno);
        System.out.println("Nombre : " + this.getNombre());
        System.out.println("Edad : " + this.getEdad());
        System.out.println("Sexo : " + this.getSexo());
    }

    public int getNumeroAlumno() {
        return numeroAlumno;
    }

    public void setNumeroAlumno(int numeroAlumno) {
        this.numeroAlumno = numeroAlumno;
    }

}
