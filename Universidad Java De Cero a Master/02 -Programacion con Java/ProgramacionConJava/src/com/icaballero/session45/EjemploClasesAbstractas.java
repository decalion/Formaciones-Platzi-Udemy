/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session45;

/**
 *
 * @author ismael
 */
public class EjemploClasesAbstractas {
    
    public static void main(String[] args) {
        FiguraGeometrica circulo = new Circulo("Circulo");
        FiguraGeometrica triangulo = new Triangulo("Triangulo");
        FiguraGeometrica rectangulo = new Rectangulo("Rectangulo");
        
        System.out.println(rectangulo);
        rectangulo.dibujar();
        
        System.out.println();
        System.out.println(triangulo);
        triangulo.dibujar();
        
        System.out.println();
        System.out.println(circulo);
        circulo.dibujar();
    }
    
}
