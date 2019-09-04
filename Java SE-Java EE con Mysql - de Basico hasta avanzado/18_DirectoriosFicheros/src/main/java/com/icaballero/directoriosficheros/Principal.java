/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.directoriosficheros;

import com.icaballero.directoriosficheros.archivos.Archivos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Principal {
    
    public static void main(String[] args) {
        try {
            Archivos.crearDirectorio("./src/prueba");
            Archivos.crearDirectorio("./src/prueba/subdirectorio");
            
            Archivos.crearArchivo("./src/prueba/test.txt");
            Archivos.crearArchivo("./src/prueba/subdirectorio/archivo1.txt");
            Archivos.crearArchivo("./src/prueba/subdirectorio/archivo2.txt");
            Archivos.crearArchivo("./src/prueba/subdirectorio/archivo3.txt");
            Archivos.crearArchivo("./src/prueba/subdirectorio/archivo4.txt");
            
            Archivos.informacionArchivo("./src/prueba/subdirectorio/archivo1.txt");
            
            Archivos.mostrarArchivosDirectorio("./src/prueba/subdirectorio");
            
            Archivos.eliminarArchivoDirectorio("./src/prueba/subdirectorio/archivo1.txt");
            Archivos.eliminarArchivoDirectorio("./src/prueba/subdirectorio/archivo2.txt");
            Archivos.eliminarArchivoDirectorio("./src/prueba/subdirectorio/archivo3.txt");
            Archivos.eliminarArchivoDirectorio("./src/prueba/subdirectorio/archivo4.txt");
            Archivos.eliminarArchivoDirectorio("./src/prueba/subdirectorio");
            
            Archivos.crearDirectorio("./src/prueba/directoriocopia");
            
            //Archivos.copiarArchivo("./src/prueba/test.txt", "./src/prueba/directoriocopia/archivo1.txt");
            
            
            
            
            Archivos.escribir("Primera linea de texto.");
            Archivos.escribir("Segunda linea de texto.");
            
            Archivos.leer();
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
