/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session48;

/**
 *
 * @author ismael
 */
public class EjemploExcepcion1 {
    
    public static void main(String[] args) {
        
        try{
            Division division = new Division(10,0);
            division.visualizarOperacion();
            
        }catch(OperationException ex){
            System.out.println("Error al dividir.");
            ex.printStackTrace();
        }
        
    }
    
}
