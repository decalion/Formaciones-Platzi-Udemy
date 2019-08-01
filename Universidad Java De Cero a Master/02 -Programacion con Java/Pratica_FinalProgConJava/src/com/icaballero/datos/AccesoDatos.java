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
import java.util.List;

/**
 *
 * @author ismael
 */
public interface AccesoDatos {
    
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx;
    public void escribir(Peliculas pelicula,String nombreArchivo,boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo , String buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    
}
