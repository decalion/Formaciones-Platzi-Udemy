/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session50.parte2;

import java.util.*;


/**
 *
 * @author ismael
 */
public class EjemploColeccionesGenericas {
    
    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("1");
        miLista.add("2");
        miLista.add("3");
        miLista.add("4");
        
        imprimir(miLista);
        
        Set<String> miSet = new HashSet<>();
        miSet.add("100");
        miSet.add("200");
        miSet.add("300");
        
        imprimir(miSet);
        
        Map<String,String> miMapa = new HashMap<>();
        miMapa.put("1", "Ismael");
        miMapa.put("2", "Juan");
        
         imprimir(miMapa.keySet());
         imprimir(miMapa.values());
         
        
    }
    
    private static void imprimir(Collection<String> col){
        
        for (String elemento : col) {
            
            System.out.println("Elemento: " + elemento);
        }
        System.out.println();
        
    }
}
