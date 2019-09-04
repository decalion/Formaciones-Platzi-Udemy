/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.app.domain;

/**
 *
 * @author ismael
 */
public abstract class Figura {

    private int ancho, alto;

    public Figura() {
        this.ancho = 0;
        this.alto = 0;
    }

    public Figura(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    
    public void mostrarDatos(){
        System.out.println("Ancho : " + this.ancho);
        System.out.println("Alto : " + this.alto);
    }
    
    public abstract float getArea();
    
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

}
