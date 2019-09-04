/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.arraylist.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ismael
 */
public class ArrayListSimple {
    
    
    public static void  usoArrayListSimple(){
       
        List meses = new ArrayList<>();
        
        
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        
        int ultimoElemento = meses.size();
        String ultimoMes = (String) meses.get(ultimoElemento-1);
        
        System.out.println("Elementos : " + ultimoElemento);
        System.out.println("Mes : " + ultimoMes);
        
        
        System.out.println(meses);
        
        meses.add(0, "Mayo");
        meses.add("Mayo");
        
        System.out.println(meses);
        
        imprimir(meses);
        
    }
    
    
    private static void imprimir(Collection col){
        
        for (Object object : col) {
            
            System.out.println(object);
            
        }
        
        System.out.println();
        System.out.println("");
        
        Iterator iter = col.iterator();
        while(iter.hasNext()){
            String mes = (String) iter.next();
            System.out.println(mes);
        }
        
        
        
    }
    
    
    
    
    
}
