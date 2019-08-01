/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session43;

/**
 *
 * @author ismael
 */
public class Escritor extends Empleado{
    
    final TipoEscritura tipoEscritura;
    
    public Escritor(String nombre, double sueldo,TipoEscritura tipoEscritura1) {
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura1;
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + "\n Tipo Escritura: " +tipoEscritura.getDescripcion();
    }
    
    
    
    
    public TipoEscritura getTipoEscritura(){
        
        return tipoEscritura;
    }
   
    public String getTipoEscrituraTexto(){
        
        return tipoEscritura.getDescripcion();
    }
    
    
    
}
