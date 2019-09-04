/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.setcollection.clases;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ismael
 */
public class SetCollection {
    
    public static void ejemploSet() {
        Agenda agenda1 = new Agenda("Ismael", "30", "99999999");
        Agenda agenda2 = new Agenda("Juan", "34", "88888888");
        Agenda agenda3 = new Agenda("Pepe", "50", "777777777");
        Agenda agenda4 = new Agenda("Rodolfo", "40", "666666666");
        
        Set<Agenda> agendaClientes = new HashSet<>();
        agendaClientes.add(agenda1);
        agendaClientes.add(agenda2);
        agendaClientes.add(agenda3);
        agendaClientes.add(agenda4);
        agendaClientes.add(agenda4);
        agendaClientes.add(agenda4);
        agendaClientes.add(agenda4);
        
        imprimir(agendaClientes);
        
        
        
    }
    
    private static void imprimir(Collection<Agenda> col) {
        
        for (Agenda agenda : col) {
            
            System.out.println(agenda);
            
        }
        
    }
    
}
