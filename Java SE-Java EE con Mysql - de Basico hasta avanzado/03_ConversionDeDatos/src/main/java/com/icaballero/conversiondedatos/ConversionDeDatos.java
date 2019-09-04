/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.conversiondedatos;

/**
 *
 * @author ismael
 */
public class ConversionDeDatos {
    
    
    public static void main(String[] args) {
        
       /* int a=1;
        double b=2.5;
        b=a;
        System.out.println("El Valor de un double es:" +b);
        */
       
        int a=1;
        double b=2.5;
        a=(int) b;
        System.out.println("El Valor de un entero es:" +a);
       
        
        int codigo = 97;
        char codigoASCCI=(char) codigo;
        System.out.println(codigoASCCI);
        
        
    }
    
}
