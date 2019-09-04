/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ismael
 */
public class MapCollection {
    
    
    public static void ejemploHashMap(){
        
        Map<String,Agenda> map = new HashMap<>();
        map.put("Ismael", new Agenda("Ismael","30","99999999"));
        map.put("Juan", new Agenda("Juan", "34", "88888888"));
        map.put("Pepe", new Agenda("Pepe", "50", "777777777"));
        map.put("Rodolfo", new Agenda("Rodolfo", "40", "666666666"));
        
        imprimir(map);
        map.remove("Pepe");
        imprimir(map);
        System.out.println("------------------------------------------");
        System.out.println(map.keySet());
        
    }
    
    private static void imprimir(Map<String,Agenda> map){
        
        System.out.println();
        
        for (Map.Entry<String, Agenda> ag : map.entrySet()) {
            
            System.out.println("Clave : " +ag.getKey() + " Valor : " + ag.getValue());
            System.out.println("Nombre: " + ag.getValue().getNombre() + 
                    " Edad: " + ag.getValue().getEdad() + 
                    " Telefono " + ag.getValue().getTelefono());
            
            
        }
        
        
        
    }
    
}
