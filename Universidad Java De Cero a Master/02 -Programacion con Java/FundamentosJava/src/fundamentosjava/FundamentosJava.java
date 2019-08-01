/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentosjava;

import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class FundamentosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Concatenar Strings
        String holaMundo= "Hola mundo";
        System.out.println(".::CONCATENACION::.");
        System.out.println("Salto de linea: \n" + holaMundo);
        System.out.println("Tabulacion: \t" + holaMundo);
        System.out.println("Retroceso \b " + holaMundo);
        System.out.println("Comilladas simples: \'" + holaMundo +"\'");
        System.out.println("Comilladas dobles: \"" + holaMundo +"\"");
        System.out.println();

        //Tipos Primitivos
        System.out.println(".::TIPO BYTE::.");
        System.out.println("Bits tipo byte: " + Byte.SIZE);
        System.out.println("Bytes tipo byte: " + Byte.BYTES);
        System.out.println("Valor minimo tipo byte: "+ Byte.MIN_VALUE);
        System.out.println("Valor maximo tipo byte: "+ Byte.MAX_VALUE);
        
        System.out.println(".::TIPO SHORT::.");
        System.out.println("Bits tipo short: " + Short.SIZE);
        System.out.println("Bytes tipo short: " + Short.BYTES);
        System.out.println("Valor minimo tipo short: "+ Short.MIN_VALUE);
        System.out.println("Valor maximo tipo short: "+ Short.MAX_VALUE);
        
        System.out.println(".::TIPO INT:.");
        System.out.println("Bits tipo int: " + Integer.SIZE);
        System.out.println("Bytes tipo int: " + Integer.BYTES);
        System.out.println("Valor minimo tipo int: "+ Integer.MIN_VALUE);
        System.out.println("Valor maximo tipo int: "+ Integer.MAX_VALUE);
        
        System.out.println(".::TIPO LONG:.");
        System.out.println("Bits tipo long: " + Long.SIZE);
        System.out.println("Bytes tipo long: " + Long.BYTES);
        System.out.println("Valor minimo tipo long: "+ Long.MIN_VALUE);
        System.out.println("Valor maximo tipo long: "+ Long.MAX_VALUE);
        
        System.out.println(".::TIPO FLOAT:.");
        System.out.println("Bits tipo Float: " + Float.SIZE);
        System.out.println("Bytes tipo Float: " + Float.BYTES);
        System.out.println("Valor minimo tipo Float: "+ Float.MIN_VALUE);
        System.out.println("Valor maximo tipo Float: "+ Float.MAX_VALUE);
        
        System.out.println(".::TIPO DOUBLE:.");
        System.out.println("Bits tipo Double: " + Double.SIZE);
        System.out.println("Bytes tipo Double: " + Double.BYTES);
        System.out.println("Valor minimo tipo Double: "+ Double.MIN_VALUE);
        System.out.println("Valor maximo tipo Double: "+ Double.MAX_VALUE);
        
        System.out.println(".::TIPO CHAR:.");
        System.out.println("Bits tipo Char: " + Character.SIZE);
        System.out.println("Bytes tipo Char: " + Character.BYTES);
        System.out.println("Valor minimo tipo Char: "+ Character.MIN_VALUE);
        System.out.println("Valor maximo tipo Char: "+ Character.MAX_VALUE);

    }
    
}
