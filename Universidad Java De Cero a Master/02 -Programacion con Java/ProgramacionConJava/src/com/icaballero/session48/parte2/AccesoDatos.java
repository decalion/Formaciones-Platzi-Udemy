/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session48.parte2;

/**
 *
 * @author ismael
 */
public interface AccesoDatos {
    
    
    public abstract void insertar() throws AccesoDatosException;
    
    public abstract void listar() throws AccesoDatosException;
    
    public abstract void simularError(boolean simularError);
}
