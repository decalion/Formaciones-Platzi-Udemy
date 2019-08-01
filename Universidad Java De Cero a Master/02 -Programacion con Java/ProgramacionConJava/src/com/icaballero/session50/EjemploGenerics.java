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
public class EjemploGenerics {
    
    public static void main(String[] args) {
        
        ClasseGenerica<Integer> objInt = new ClasseGenerica<Integer>(15);
        objInt.obtenerTipo();
        
        ClasseGenerica<String> objStr = new ClasseGenerica<String>("Prueba");
        objStr.obtenerTipo();
    }
    
}
