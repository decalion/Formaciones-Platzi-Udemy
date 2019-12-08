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
public class OperadoresAritmeticos {
    
    
    public static void main(String[] args) {
        
        int a=3 , b=2;
        int resultado = a +b;
        
        System.out.println("Resultado " + resultado);
        
        //No suma , concatena cadenas
        System.out.println("Resultado "+ a + b);
        
        //Primero suma luego caoncatena
        System.out.println("Resultado " + (a+b));
        
        //Resta
         System.out.println("Resultado " + (a-b));
         
         //Multiplicar
         System.out.println("Resultado " + (a*b));
         
         //Dividir
         System.out.println("Resultado " + (a/b));
         double result = 3F/b;
         System.out.println("Resultado " + result);
         
         //Resto
         System.out.println("Resultado " + (a%b));
        
        
    }
            
    
}
