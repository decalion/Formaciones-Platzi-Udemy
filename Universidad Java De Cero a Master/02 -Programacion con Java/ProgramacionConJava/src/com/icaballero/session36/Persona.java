/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session36;

/**
 *
 * @author ismael
 */
public class Persona {
    
    private final int idPersona;
    private static int contadorPersonas;
    
     //Bloque de codigo statico para inicializar variables estaticas (Solo se puedes utilizar variables o metodos estaticos). Se llama solo 1 vez
    static{
        System.out.println("Se ejecuta el bloque estatico");
        contadorPersonas = 10;
    }
    
    //Bloque de codigo  se ejecuta antes del construcror  cada vez que se realice una instancia de la clase.
    {
        System.out.println("Ejecutar bloque inicializador");
        idPersona = ++contadorPersonas;
    }
    
   

    public Persona() {
        System.out.println("Ejecutar Constructor");
    }
    
    
    
    public int getIdPersona(){
        return idPersona;
    }
}
