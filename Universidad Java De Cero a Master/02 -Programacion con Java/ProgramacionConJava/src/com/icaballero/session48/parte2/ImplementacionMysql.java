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
public class ImplementacionMysql implements AccesoDatos{
    
    private boolean simularError;

    @Override
    public void insertar() throws AccesoDatosException {
        if(simularError){
            throw new EscrituraDatosException("Error Escritura de datos");
        }else{
            System.out.println("Insertar desde Mysql");
        }
    }

    @Override
    public void listar() throws AccesoDatosException {
          if(simularError){
            throw new LecturaDatosException("Error Lectura de datos");
        }else{
            System.out.println("Listar desde Mysql");
        }
    }

    public boolean isSimularError(){
        return this.simularError;
    }
    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }
    
}
