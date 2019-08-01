/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session48.parte2;

/**
 *
 * @author ismael
 */
public class EjemploExcepciones3 {
    
    public static void main(String[] args) {
        AccesoDatos datos = new ImplementacionMysql();
        datos.simularError(true);
        ejecutar(datos, "listar");
        
        datos.simularError(false);
        System.out.println();
        ejecutar(datos, "insertar");
    }
    
    private static void ejecutar(AccesoDatos datos, String accion){
        
        if("listar".equals(accion)){
            try{
                datos.listar();
            }
        catch(LecturaDatosException ex){
                System.out.println("Errror lectura");
            }catch(AccesoDatosException ex){
                
                System.out.println("Error de acceso a datos");
            }catch(Exception ex){
                System.out.println("Error General");
            }finally{
                System.out.println("Opcional, se ejecuta siempre haya o no error");
            }
        }else if("insertar".equals(accion)){
            
            try{
                datos.insertar();
            }catch(AccesoDatosException ex){
                System.out.println("Error de acceso a datos");
            }finally{
                System.out.println("Opcional, se ejecuta siempre haya o no error");
            }
        }else{
            System.out.println("No se ha proporcionado ninguna accion conocida");
        }
        
    }
    
}
