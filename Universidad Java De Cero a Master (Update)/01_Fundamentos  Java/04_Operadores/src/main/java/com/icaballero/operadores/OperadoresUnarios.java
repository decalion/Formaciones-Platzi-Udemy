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
public class OperadoresUnarios {
    
    public static void main(String[] args) {
        
       //Invertir el signo
        int a  =3;
        int b = -a;
        System.out.println("b : " +b);
        boolean c = true;
        boolean d = !c;
        System.out.println("d = " + d);
        
        //incremento
        //preincremento
        int e = 3;
        int f = ++e;
        System.out.println("e = "+e);
        System.out.println("f = "+e);
        //postincremento
        int g = 5;
        int h = g++;
        System.out.println("g = " +g);
        System.out.println("h = "+h);
        
        
        
    }
    
}
