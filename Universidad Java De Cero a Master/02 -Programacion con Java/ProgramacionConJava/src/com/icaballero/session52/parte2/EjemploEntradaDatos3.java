/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session52.parte2;

import java.util.*;

/**
 *
 * @author ismael
 */
public class EjemploEntradaDatos3 {
    
    public static void main(String[] args) {
        
        Scanner escaner = new Scanner(System.in);
        System.out.println("Proporciona el primer valor : ");
        int a = escaner.nextInt();
        System.out.println("Proporciona el segundo valor : ");
        int b = escaner.nextInt();
        int resultado = Operaciones.sumar(a, b);
        
        System.out.println("El resultado de la suma: " + resultado);
    }
    
}
