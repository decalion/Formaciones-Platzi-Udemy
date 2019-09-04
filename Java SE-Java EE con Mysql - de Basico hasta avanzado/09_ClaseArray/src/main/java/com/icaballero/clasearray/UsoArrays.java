/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.clasearray;

import java.util.Arrays;

/**
 *
 * @author ismael
 */
public class UsoArrays {
    
    //int[] cantidades= new int[5];
    
    int[] cantidades = {5,4,2,3,1};
    
    public static void main(String[] args) {
        
        UsoArrays obj = new UsoArrays();
       // obj.insertarValores();
        obj.leerArray();
        System.out.println("------------------");
        obj.ordenarValores();
        obj.leerArray();
        
        System.out.println("-----------------");
        obj.buscarValores();
        
    }
    
    
    public void buscarValores(){
        String[] nombresEmpleados={"pedro","maria","juan"};
        Arrays.sort(nombresEmpleados);
        int index = Arrays.binarySearch(nombresEmpleados,"pedro");
        
        System.out.println("La palabra pedro esta en el indice="+index);
        
        
        
    }
    
    public void ordenarValores(){
        
        Arrays.sort(cantidades);
    }
    
    public void insertarValores(){
        
        Arrays.fill(cantidades,100);
        
        
    }
    
    
    
    public void leerArray(){
        for (int valor : cantidades) {
            
            System.out.println(valor);
            
        }
    }
    
    
}
