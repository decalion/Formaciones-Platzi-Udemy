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
public class Profesor extends Persona {

    private String areaProfesional;
    private String especialidad;

    public Profesor() {
    }

    public Profesor(String areaProfesional, String especialidad, String nombre, int edad, String sexo) {
        super(edad, nombre, sexo);
        this.areaProfesional = areaProfesional;
        this.especialidad = especialidad;

    }

    public String getAreaProfesional() {
        return areaProfesional;
    }

    public void setAreaProfesional(String areaProfesional) {
        this.areaProfesional = areaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
