/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodemath;

/**
 *
 * @author ismael
 */
public class Main {
    
    
    public static void main(String[] args) {
        Main obj = new Main();
        
        obj.numerosAleatorios();
        System.out.println("---------------");
        obj.maximoMinimo();
        System.out.println("---------------");
        obj.mayorMenorParametro();
        System.out.println("---------------");
        obj.redondeo();
        System.out.println("---------------");
        obj.potencia();
        System.out.println("---------------");
        obj.raizCuadrada();
       
    }
    
    public void raizCuadrada(){
        double a =5;
        
        System.out.println("La raiz cuadra de "+a+" es="+Math.sqrt(a));
    }
    
    public void potencia(){
        double a=2.0;
        double b = 5.0;
        
        System.out.println("El resultado de elevar " +a + "a " + b +" es=" + Math.pow(a, b) );
    }
    
    
    public void redondeo(){
        double a=5.8;
        double b=5.3;
        
        System.out.println("El redondeo del numero 5.8  es: "+Math.round(a));
        System.out.println("El redondeo del numero 5.3 es: "+Math.round(b));
                
    }
    
    public void mayorMenorParametro(){
        double numero=5.1;
        System.out.println("El entero mayor del numero es "+ Math.ceil(numero));
    }
    
    
    
    public void maximoMinimo(){
        int numero1=1000;
        int numero2=999;
                
        System.out.println("El mayor de los dos numeros es "+ Math.max(numero1, numero2));   
        System.out.println("El menor de los dos numeros es "+ Math.min(numero1, numero2));
    }
    
    public void numerosAleatorios(){
        
        for (int i = 0; i < 10; i++) {
            int aleatorio=(int)(Math.random()*10+1);
            
            System.out.println(aleatorio);
        }
    }
    
}
