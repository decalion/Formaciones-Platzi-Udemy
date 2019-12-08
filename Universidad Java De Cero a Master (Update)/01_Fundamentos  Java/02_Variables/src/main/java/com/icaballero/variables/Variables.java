/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.variables;

/**
 *
 * @author ismael
 */
public class Variables {

    public static void main(String[] args) {

        /**
         * VARIABLES
         * 
         * var solo se puede usar con JDK 10 o superior
         */
        String saludar = "Saludo desde Java";

        System.out.println(saludar);
        System.out.println(saludar);
        System.out.println(saludar);

        var despedirse = "Hasta luego";

        System.out.println(despedirse);

        //int
        var numero = 1;

        /**
         * CONCATENACION
         */
        var usuario = "Ismael";
        var saludo = "Hola";

        System.out.println(saludo + " " + usuario);

        var i = 3;
        var j = 5;
        System.out.println(i + j);

        //Concatena todo ya que lo primero que hay es un String
        System.out.println(saludo + i + j);
        
        //Primero suma y luego cancatena
        System.out.println(i + j +saludo);
        
        /**
         * CARACTARSS ESPPECIALES
         */
        
        String nombre = "Juan";
        String apellido = "Perez";
        System.out.println(nombre + " " + apellido);
        System.out.println("Nueva linea: \n"+nombre);
        System.out.println("Tabulacion: \t"+nombre);
        System.out.println("Retroceso: \b\b"+nombre);
        System.out.println("Retorno de carro: \r"+nombre);
        System.out.println("comilla simple \'"+nombre+"\'");
        System.out.println("Comilla doble: \""+nombre+"\"");
        System.out.println("Saludos");
        System.out.print("adios ");
        System.out.print("adios");
        
        

    }
}
