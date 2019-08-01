/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.negocio;

import com.icaballero.datos.AccesoDatos;
import com.icaballero.datos.AccesoDatosImpl;
import com.icaballero.domain.Peliculas;
import com.icaballero.excepciones.AccesoDatosEx;
import com.icaballero.excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author ismael
 */
public class CatalagoPeliculasImpl implements CatalagoPeliculas{
    private AccesoDatos datos;

    public CatalagoPeliculasImpl() {
        
        datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
       Peliculas pelicula = new Peliculas(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
          try {
            List<Peliculas> peliculas = datos.listar(nombreArchivo);
            for (Peliculas pelicula : peliculas) {
                System.out.println("Pelicula:" + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
         String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo,buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("Resultado busqueda:" + resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
          try {
            if (datos.existe(nombreArchivo)) {
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //creamos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    
    
    
    
  }
    

