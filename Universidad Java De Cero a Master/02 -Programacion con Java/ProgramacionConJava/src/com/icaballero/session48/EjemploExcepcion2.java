/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.session48;

/**
 *
 * @author ismael
 */
public class EjemploExcepcion2 {
    
    public static void main(String[] args) throws OperationException {
        
        try{
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[1]);
            Division div = new Division(op1, op2);
            div.visualizarOperacion();
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Un elemento esta fuera de rango");
            ex.printStackTrace();
        }catch(NumberFormatException ex){
            System.out.println("Uno de los argumentos no es entero");
            ex.printStackTrace();
        }catch(OperationException ex){
            System.out.println("Operacion errornea");
            ex.printStackTrace();
        }finally{
            System.out.println("Se terminaron de pasar las excepciones");
        }
        
    }
    
}
