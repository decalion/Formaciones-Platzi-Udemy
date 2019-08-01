/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session53;

import static com.icaballero.session53.Archivos.*;
/**
 *
 * @author ismael
 */
public class EjemploArchivos {
    
    private static final String NOMBRE_ARCHIVO = "..//pruebaJava.txt";
    
    public static void main(String[] args) {
        crearArchivo(NOMBRE_ARCHIVO);
        
        escribirArchivo(NOMBRE_ARCHIVO);
        
        leerArchivo(NOMBRE_ARCHIVO);
        
        anexarArchivo(NOMBRE_ARCHIVO);
        
        leerArchivo(NOMBRE_ARCHIVO);
        
        
    }
}
