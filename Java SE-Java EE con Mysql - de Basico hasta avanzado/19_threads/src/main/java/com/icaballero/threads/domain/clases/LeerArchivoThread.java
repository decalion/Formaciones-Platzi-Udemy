/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.threads.domain.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class LeerArchivoThread extends Thread {

    public static Path path;
    static File file;

    public LeerArchivoThread(String nombre) {
       super(nombre);
        path = Paths.get("./src/prueba/test.txt");
        file = path.toFile();
        
    }

    public LeerArchivoThread(String nombre,String ruta) {
        super(nombre);
        path = Paths.get(ruta);
        file = path.toFile();
        
        
    }

    @Override
    public void run() {

        try ( BufferedReader inputStream = new BufferedReader(
                new FileReader(file))) {

            String linea = inputStream.readLine();

            while (linea != null) {
                System.out.println(linea + " PROCESO " + this.getName());
                linea = inputStream.readLine();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BucleThread.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
            System.out.println("Proceso: " + this.getName() + " Terminado");

        } catch (IOException e) {

        }

    }

}
