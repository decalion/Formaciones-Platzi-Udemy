/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.herencia;

/**
 *
 * @author ismael
 */
public class Empleado extends Persona{
    
    private Integer idEmpledo;
    private Double sueldo;
    private static int contadorEmpleados = 0;

    public Empleado(String nombre,Double sueldo) {
        super(nombre);
        this.idEmpledo = ++contadorEmpleados;
        this.sueldo = sueldo;
    }

    public Integer getIdEmpledo() {
        return idEmpledo;
    }

    public void setIdEmpledo(Integer idEmpledo) {
        this.idEmpledo = idEmpledo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
    
    
    
    
}
