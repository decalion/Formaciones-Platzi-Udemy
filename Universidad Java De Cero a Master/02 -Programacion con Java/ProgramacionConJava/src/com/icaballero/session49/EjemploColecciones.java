/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session49;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ismael
 */
public class EjemploColecciones {
    public static void main(String[] args) {
        List miLista = new ArrayList();
        miLista.add("1");
        miLista.add("2");
        miLista.add("3");
        miLista.add("4");
        miLista.add("4");
        
        imprimir(miLista);
        
        Set miSet = new HashSet();
        miSet.add("100");
        miSet.add("200");
        miSet.add("300");
        
        imprimir(miSet);
        
        
        Map miMapa = new HashMap();
        
        miMapa.put("1", "ismael");
        miMapa.put("2", "juan");
        
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
        
        
    }
    
    private static void imprimir(Collection coleccion){
        
        for (Object elemento : coleccion) {
            
            System.out.println("Elemento: " + elemento);
        }
        System.out.println();
    }
    
    
    
    
    
}
