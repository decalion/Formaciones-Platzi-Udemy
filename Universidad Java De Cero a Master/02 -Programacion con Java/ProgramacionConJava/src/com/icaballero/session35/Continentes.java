/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session35;

/**
 *
 * @author ismael
 */
public enum Continentes {
    
    AFRICA(53),
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);
    
    //En la constante se guarda el calor de cada pais para europa guarda el numero 46
    private final int paises;
    
    //Se llama de manmera automatica por cada atributo
    private Continentes(int paises) {
        this.paises = paises;
    }
    
    public int getPaises(){
        return paises;
    }
}
