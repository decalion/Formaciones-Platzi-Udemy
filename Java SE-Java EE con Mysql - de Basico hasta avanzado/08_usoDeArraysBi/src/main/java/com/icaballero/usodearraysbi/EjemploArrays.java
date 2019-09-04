/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodearraysbi;

/**
 *
 * @author ismael
 */
public class EjemploArrays {
    
    
    int [][] matrizDeEnteros = new int[3][4];
    
   // int [][]matrizDeEnteros = {{1,3,5,7},{5,4,1,16},{7,9,61,13}};
    
    
    public static void main(String[] args) {
        
        EjemploArrays obj = new EjemploArrays();
        obj.asignaValores();
        obj.leerArrayBidemensional();
        
    }
    
    
    
    
    
    public void asignaValores(){
        
        matrizDeEnteros[0][0]=1;
        matrizDeEnteros[0][1]=3;
        matrizDeEnteros[0][2]=5;
        matrizDeEnteros[0][3]=7;
        
        matrizDeEnteros[1][0]=5;
        matrizDeEnteros[1][1]=4;
        matrizDeEnteros[1][2]=1;
        matrizDeEnteros[1][3]=16;
        
        matrizDeEnteros[2][0]=7;
        matrizDeEnteros[2][1]=9;
        matrizDeEnteros[2][2]=61;
        matrizDeEnteros[2][3]=13;
        
        
        
    }
    
    
    public void leerArrayBidemensional(){
        
        for(int[] fila : matrizDeEnteros){
            for(int columna : fila){
                System.out.print(columna +" ");
            }
            System.out.print("\n");
        }
    }
    
    
    
    
    
    
    
}
