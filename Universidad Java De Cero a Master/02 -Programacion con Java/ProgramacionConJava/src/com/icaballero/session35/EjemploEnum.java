/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session35;
import static com.icaballero.session35.Dias.*;
import static com.icaballero.session35.Continentes.*;

/**
 *
 * @author ismael
 */
public class EjemploEnum {
    
    public static void main(String[] args) {
        System.out.println("Valor Lunes : " + LUNES);
        indicarDia(LUNES);
        
        System.out.println("Valor Europa " + EUROPA);
        System.out.println("Numero de paises EUOPA " + EUROPA.getPaises());
        
        indicarContinente(EUROPA);
        imprimirContinentes();
    }
    
    public static void indicarDia(Dias dia){
        switch(dia){
            
           case LUNES:
               System.out.println("Primer dia de la semana");
               break;
        }
    }
        
     public static void indicarContinente(Continentes continente){
        switch(continente){
            
           case EUROPA:
               System.out.println("Numero de paises  " +EUROPA.getPaises() +" de " + EUROPA);
               break;
        }
        
    }
     
     public static void imprimirContinentes(){
         //Values devuelve el total de valores de la enum
         for (Continentes c : Continentes.values()) {
             System.out.println("Continente " + c + " contiene " + c.getPaises() + " Paises");
             
         }
     }
     
     
     
}
