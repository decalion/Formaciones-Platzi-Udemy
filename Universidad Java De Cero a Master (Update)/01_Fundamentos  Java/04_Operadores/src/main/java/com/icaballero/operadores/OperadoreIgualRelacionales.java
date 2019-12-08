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
public class OperadoreIgualRelacionales {
    
    public static void main(String[] args) {
        int a=3, b=2;
        
        // a es igual b =
        boolean c =(a == b);     
        System.out.println("c = "+c);
        
        //a es diferente de b
        c = (a!=b);
        System.out.println("c  = " + c);
        
        //Comparar cadenas
        String cadena = "Hola";
        String cadena2  ="Adios";
        System.out.println(cadena.equals(cadena2));
        
        //a es menor que b
        boolean d = a < b;
        System.out.println("d = " +d);
        
        
        
    }
    
}
