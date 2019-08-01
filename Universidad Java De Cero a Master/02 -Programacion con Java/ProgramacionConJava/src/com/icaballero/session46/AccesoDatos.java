/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session46;

/**
 *
 * @author ismael
 */
public interface AccesoDatos {
    
    //por defecto son public y static
    public static int MAX_REGISTROS = 10;
    
    //por defecto son public y abstract
    public abstract void insertar();
    public abstract void listar();
    
    
    
}
