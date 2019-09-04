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
public class StringBasics {
    
   public void showStrings(){
       
      String mensaje1 ="Entrada de datos o cadena valida";
      String mensaje2 ="";
      String mensaje3 =null;
       
       mensaje1+=" Esta es una concatenacion";
      
      System.out.println(mensaje1);
      System.out.println(mensaje2);
      System.out.println(mensaje3);
      
      
      /*    CARACTERES ESPECIALES EN STRINGS
        \n nueva linea
        \t tabulacion
        \r retorno de carro
        \" dobles comillas
        \\ backslash

      */
       
       String caracter;
       
       caracter = "CODIGO: JSP\nPrecio: $50.00";

       System.out.println(caracter);
       
       caracter="Codigo:\tJSP\r\nPrecio:\t$50.00";
       System.out.println(caracter);
       
       caracter="presiona la letra \"x\" para salir";
       System.out.println(caracter);
       
       caracter="c:\\java\\ejercicios";
       System.out.println(caracter);
       
   }
    
    
}
