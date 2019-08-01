/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.mundopc;

/**
 *
 * @author ismael
 */
public class Teclado extends DispositivoEntrada {
    
    private int idTeclado;
    private int contadorTeclados;
    
    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
    }

    public int getIdTeclado() {
        return idTeclado;
    }

    public void setIdTeclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }

    public int getContadorTeclados() {
        return contadorTeclados;
    }

    public void setContadorTeclados(int contadorTeclados) {
        this.contadorTeclados = contadorTeclados;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
