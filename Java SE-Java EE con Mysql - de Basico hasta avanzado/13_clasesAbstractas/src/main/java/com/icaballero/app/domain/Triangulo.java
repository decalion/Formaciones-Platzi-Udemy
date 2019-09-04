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
public class Triangulo extends Figura{

    public Triangulo() {
        super();
    }

    public Triangulo(int ancho, int alto) {
        super(ancho, alto);
    }
    
    
    

    @Override
    public float getArea() {
        return (this.getAncho()*this.getAlto())/2;
    }
    
    
    
}
