/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.datos;

import com.icaballero.domain.Peliculas;
import com.icaballero.excepciones.AccesoDatosEx;
import com.icaballero.excepciones.EscrituraDatosEx;
import com.icaballero.excepciones.LecturaDatosEx;
import java.io.*;
import java.util.*;

/**
 *
 * @author ismael
 */
public class AccesoDatosImpl implements AccesoDatos{

    public AccesoDatosImpl() {
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        
        return archivo.exists();
    }

    @Override
    public List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Peliculas> lista = new ArrayList<Peliculas>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = reader.readLine();
            while(linea !=null){
                Peliculas pelicula = new Peliculas(linea);
                lista.add(pelicula);
                linea = reader.readLine();
                
            }
            
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        return lista;
    }

    @Override
    public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        
        try{
            PrintWriter escribir = new PrintWriter(new FileWriter(archivo,anexar));
            escribir.println(pelicula.getNombre());
            escribir.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
       File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
         File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo correctamente");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo correctamente");
    }


    
}
