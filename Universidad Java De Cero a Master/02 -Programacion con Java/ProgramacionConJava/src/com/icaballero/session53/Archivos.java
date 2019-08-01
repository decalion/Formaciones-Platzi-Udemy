/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session53;
import java.io.*;

/**
 *
 * @author ismael
 */
public class Archivos {
    
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("El archivo se ha creado correctamente\n");
            
        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    public static void escribirArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            String contenido = "Contenido a escribir en el archivo";
            salida.println(contenido);
            salida.println();
            salida.println("Fin escritura");
            salida.close();
            System.out.println("Se ha escrito correctamente\n");
            
        }catch(IOException e){
            e.printStackTrace(); 
        }
        
    }
    
    
    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            lectura = entrada.readLine();
            
            while(lectura != null){
                System.out.println("Lectura: " + lectura);
                
                lectura = entrada.readLine();
            }
            
            entrada.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void anexarArchivo(String nombreArchivo){
            File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            String contenido = "Anexar Informacion";
            salida.println(contenido);
            salida.println();
            salida.println("Fin anexar");
            salida.close();
            System.out.println("Se ha anexado informacion correctamente\n");
            
        }catch(IOException e){
            e.printStackTrace(); 
        }
        
        
    }
    
    
    
    
}
