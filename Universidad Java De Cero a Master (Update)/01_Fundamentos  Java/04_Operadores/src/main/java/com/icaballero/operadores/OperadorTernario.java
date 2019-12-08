/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.operadores;

/**
 *
 * @author ismael
 */
public class OperadorTernario {
    
    
    public static void main(String[] args) {
        
        /**
         * var resultado = (expresion) ? true : false
         * 
         */
        
        var resultado = (3>2) ? "Verdadero" : "falso";
        System.out.println("Resultado = " + resultado);
        
        int numero = 2;
        var par = (numero % 2  == 0) ? "Numero par" : "Numeri inpar";
        System.out.println(par);
        
        
        
    }
}
