/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session50;

/**
 *
 * @author ismael
 */
public class ClasseGenerica<T> {
    
    T objeto;

    public ClasseGenerica(T objeto) {
        this.objeto = objeto;
    }
    
    public void obtenerTipo(){
        System.out.println("T es de tipo " + objeto.getClass().getName());
    }
    
}
