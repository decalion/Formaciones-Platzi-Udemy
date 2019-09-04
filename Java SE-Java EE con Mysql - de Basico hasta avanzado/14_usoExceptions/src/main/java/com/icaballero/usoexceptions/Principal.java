/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usoexceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Principal {
    
    public static void main(String[] args) {
        
        int resultado;
        try {
            resultado = division(6, 0);
            System.out.println("Resultado : " + resultado);
        } catch (DividedByZeroException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public static int division(int numerador,int denominador) throws DividedByZeroException{

        if(denominador<=0){
            throw new DividedByZeroException("El denominador no puede ser menor o igual a zero");
            
        }
        
        int resultado = numerador/denominador;
        
        return resultado;
        
    }
    
    
}
