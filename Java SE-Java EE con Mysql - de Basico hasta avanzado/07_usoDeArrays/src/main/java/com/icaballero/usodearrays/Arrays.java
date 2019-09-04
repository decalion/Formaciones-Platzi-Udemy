/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodearrays;

import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class Arrays {
    
    private final int BIMESTRES=6;
    private final int CALIFICACION_APROBATORIA;
    private double calificaciones[] = new double [6];

    
    public static void main(String[] args) {
        Arrays obj = new Arrays(70);
        obj.solicitaCalificaciones();
        obj.imprimirCalificacionBimestre();
        
        System.out.println("La media semestral es : "+obj.calculaPromedio());
        
        
    }
    
    public double calculaPromedio(){
        double sum=0;
        for (double calificacion : calificaciones) {
            
            sum+=calificacion;
            
        }
        
        return sum/BIMESTRES;
    }
    
    
    public Arrays(int calificacionAprobatori) {
        this.CALIFICACION_APROBATORIA = calificacionAprobatori;
    }
    
    
    public void imprimirCalificacionBimestre(){
        
        for (int i = 0; i < calificaciones.length; i++) {
            if(calificaciones[i]<CALIFICACION_APROBATORIA){
                
                System.out.println("CON UN " + calificaciones[i] +" Suspendes el Bimestre");
                
            }else{
                System.out.println("CON UN " + calificaciones[i] +" Apruebas el Bimestre");
            }
            
        }
        
    }
    
    
    
    public void solicitaCalificaciones(){
        Scanner entrada = new Scanner(System.in);
        double calificacion;
        
        for (int i = 0; i < calificaciones.length; i++) {
            
            System.out.println("Calificacion para el bimestre "+(i+1));
            calificacion = entrada.nextDouble();
            calificaciones[i]=calificacion; 
        }
        
    }
    

    
}
