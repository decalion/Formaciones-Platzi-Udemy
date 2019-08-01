/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session52;
import java.io.*;

/**
 *
 * @author ismael
 */
public class EjemploEntradaDatos {
    
    public static void main(String[] args) {
        String captura;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bInput = new BufferedReader(input);
        
        try{
            System.out.println("Introduce dato: ");
            captura = bInput.readLine();
            
            while(captura != null){
                System.out.println("Dato Introduccido : " + captura);
                captura = bInput.readLine();
            
             }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
}
