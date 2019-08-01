/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session52;

import java.util.*;
/**
 *
 * @author ismael
 */
public class EjemploEntradaDatos2 {
    
    public static void main(String[] args) {
        String captura = null;
        Scanner escaner = new Scanner(System.in);
        System.out.println("Introduce un dato:");
        captura = escaner.nextLine();
        
        while(captura != null){
            System.out.println("Dato Introducido: " + captura);
            captura = escaner.nextLine();
        }
        
        
        
    }
    
}
