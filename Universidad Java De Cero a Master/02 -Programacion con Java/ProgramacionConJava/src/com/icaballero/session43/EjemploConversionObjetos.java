/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session43;

/**
 *
 * @author ismael
 */
public class EjemploConversionObjetos {
    
    public static void main(String[] args) {
        
        Empleado empleado;
        empleado = new Escritor("Ismel", 15000, TipoEscritura.CLASICO);
        imprimirDetalles(empleado);
        
        empleado = new Gerente("Juan", 20000, "Sistemas");
        imprimirDetalles(empleado);
    }
    
    private static void imprimirDetalles(Empleado empleado){
        String resultado = null;
        
        if(empleado instanceof Escritor){
            
            //Escritor escritor = (Escritor)empleado;
            //resultado = empleado.obtenerDetalles();
            
            resultado=((Escritor )empleado).getTipoEscrituraTexto();
            
            System.out.println("Tipo Escrirua : "+resultado);
        }else if (empleado instanceof Gerente){
            
            resultado = ((Gerente)empleado).getDepartamento();
            
            System.out.println("Departamento: "+resultado);
            
        }
        
        
    }
    
}
