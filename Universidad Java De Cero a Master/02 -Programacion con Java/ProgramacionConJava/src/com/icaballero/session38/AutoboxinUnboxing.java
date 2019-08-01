/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session38;

/**
 *
 * @author ismael
 */
public class AutoboxinUnboxing {
    
    public static void main(String[] args) {
        
        Integer enteroOnj = 10;
        Float flotanteObj = 15.5F;
        Double dobleObj = 40.1;
        System.out.println("Autoboxing");
        System.out.println("Entero Object: " +enteroOnj);
        System.out.println("Flotante Object: " +flotanteObj);
        System.out.println("Double Object: " +dobleObj);
        System.out.println();
        int entero = enteroOnj;
        float flotante = flotanteObj;
        double doble = dobleObj;
        System.out.println("Unboxing");
        System.out.println("Entero : " +entero);
        System.out.println("Flotante : " +flotante);
        System.out.println("Double  " +doble);
        
        
    }
    
    
}
