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
public class Rectangulo extends Figura{

    @Override
    public float getArea() {
       
        return this.getAlto()*this.getAncho();
    }
    
}
