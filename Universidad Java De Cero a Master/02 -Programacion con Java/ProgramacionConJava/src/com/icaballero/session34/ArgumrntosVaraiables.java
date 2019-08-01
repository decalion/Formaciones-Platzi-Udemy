/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session34;

/**
 *
 * @author ismael
 */
public class ArgumrntosVaraiables {
    
        public static void main(String[] args) {
            imprimirNumeros("Ismael",true,10,1,12,15,198,234,12);
    }
    
        
        //Con ... se define que vamos a recibir x numeros(Argumentos variables)
        //Se se tienen que utilizar argumentos variables(var args) tiene que ser el ultimo en llamarse
        public static void imprimirNumeros(String nombre, boolean valido, int... numeros){
            System.out.println("nombre : " +nombre);
            System.out.println("valido : "+valido);
           
            for (int numero : numeros) {
                System.out.println("Numero : " +numero);
                
                
            }
        }
}
