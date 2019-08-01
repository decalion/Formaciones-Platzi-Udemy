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
public class ImplementacionOracle implements AccesoDatos{

    @Override
    public void insertar() {
        System.out.println("Insertar datos desde Oracle");
    }

    @Override
    public void listar() {
        System.out.println("Listar datos desde Oracle");
    }
    
}
