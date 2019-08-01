/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session46;

/**
 *
 * @author ismael
 */
public class EjemploInterfaces {

    public static void main(String[] args) {
        AccesoDatos datos = new ImplementacionOracle();
        ejecutar(datos, "listar");
        
        datos = new ImplementacionMysql();
        ejecutar(datos, "insertar");
                
        
    }
    
    private static void ejecutar(AccesoDatos datos, String accion){
        
        if("listar".equals(accion)){
            datos.listar();
        }else if("insertar".equals(accion)){
            datos.insertar();
        }
    }
    
}
