/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodestring;

/**
 *
 * @author ismael
 */
public class CompararStrings {
    
    
    public void compararDtrings(){
        
        String nombre="Ismael";
        
        if (nombre.equals("Ismael")) {
            
            System.out.println("Si corresponde al nombre");
            
        }
        
        nombre="";
        if (nombre.equals("")) {
            
            System.out.println("La cadena esta vacia");
        }
        
        if (nombre.isEmpty()) {
            System.out.println("La cadena esta vacia isEmpty");
        }
        
        nombre="ISMAEL CABALLERO HERNANDEZ";
        
        if (nombre.startsWith("ISMAEL")) {
            
            System.out.println("El nombre empieza por Ismael");
            
        }
        if (nombre.endsWith("HERNANDEZ")) {
            
            System.out.println("El apellido termina con Hernandez");
            
        }
        
        String cadena="Esto es un curso de Java";
        int lenght= cadena.length();
        System.out.println("El tamaño de la cadena es de : " +lenght);
        
        cadena="";
        if (cadena.length()==0) {
            System.out.println("Cadena vacia");
            
        }
        
        cadena="Esto es un curso de Java";
        String cadenaBuscada="un";
        int indice = cadena.indexOf(cadenaBuscada);
        System.out.println("La posicion donde se encontro la cadena es "+indice);
                
        
        char caracter=cadena.charAt(2);
        System.out.println("El caracter en la pocicion 2 es : "+caracter);
        
        
        
        String cadenaConEspacios="  esta es una cadena con espacios  ";
        System.out.println(cadenaConEspacios);
        System.out.println(cadenaConEspacios.trim());
        
        
        
        String numCta="7987 6565 7867 9876";
        String cuatroUltimosCaracteres = numCta.substring(5,9);
        System.out.println(cuatroUltimosCaracteres);
        
        
        
    }
    
}
