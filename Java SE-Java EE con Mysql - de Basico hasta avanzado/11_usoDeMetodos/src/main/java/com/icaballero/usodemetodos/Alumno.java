/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodemetodos;

/**
 *
 * @author ismael
 */
public class Alumno {

    private double calificacion;
    private String nombre;
    private int edad;
    static double cuotaSemestral;

    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void setDatosAlumno(String nombre) {

        this.nombre = nombre;
    }

    public void setDatosAlumno(double calificacion) {
        this.calificacion = calificacion;

    }

    public void setDatosAlumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;

    }

    public void setDatosAlumno(String nombre, int edad, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;

    }

    public static void muestraCoutaSemestral() {
        System.out.println("La cuota semestral es de : " + cuotaSemestral);
    }

    public void muestraInformacionAlumno() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Calificacion : " + calificacion);
        System.out.println("Edad : " + edad);
        muestraCoutaSemestral();
    }

}
