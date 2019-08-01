/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session48;

/**
 *
 * @author ismael
 */
public class Division {
    
    private int numerador;
    private int denominador;

    public Division(int numerador, int denominador) throws OperationException {
       if (denominador == 0){
           throw new OperationException("Denominador igual a cero");
       }
       this.numerador = numerador;
       this.denominador = denominador;
    }

    public void visualizarOperacion(){
        System.out.println("El resultado es : " + (numerador / denominador));
    }
    
    
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    
    
}
