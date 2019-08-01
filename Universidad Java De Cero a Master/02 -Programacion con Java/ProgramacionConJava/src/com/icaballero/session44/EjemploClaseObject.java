/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session44;

/**
 *
 * @author ismael
 */
public class EjemploClaseObject {
    
    public static void main(String[] args) {
        
        Empleado emp1 = new Empleado("ismael", 22000);
        Empleado emp2 = new Empleado("ismael", 22000);
         
         compararObjetos(emp1, emp2);
        
    }
    
    private static void compararObjetos(Empleado emp1,Empleado emp2){
        System.out.println("Contenido emp1" + emp1);
        
        if(emp1 == emp2){
            System.out.println("Los objetos tienen la misma direccion de memoria");
            
        }else{
            System.out.println("Los objetos NO tienen distinta direccion de memoria");
        }
        
        if(emp1.equals(emp2)){
            System.out.println("Los objetos tienen el mismo contenido son iguales");
        }else{
            System.out.println("Los objetos NO tienen el mismo contenido, NO son iguales");
        }
        
        if(emp1.hashCode() == emp2.hashCode()){
            System.out.println("Los objetos tienen el mismo codigo hash");
        }else{
            System.out.println("Los objetos NO tienen el mismo codigo hash");
        }
        
    }
    
}
