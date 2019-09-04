/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.tiposdedatos;

/**
 *
 * @author ismael
 */
public class TipoDeDatos {

    public static void main(String[] args) {

        boolean esMayorDeEdad;
        esMayorDeEdad = false;

        char miCaracter = 'a';
        //Ejemplo de unicode
        miCaracter = '\u00B6';

        System.out.println("La Variable esMayorDeEdad=" + esMayorDeEdad);
        System.out.println("Mi Variable miCaracter=" + miCaracter);

        mostrarInformacion();

        int valorEntero = 10 / 3; //32bit
        float valorFlotante = 10f / 3f; //32bits
        double valorDouble = 10d / 3d;  //64bits

        System.out.println("Valor entero = " + valorEntero);
        System.out.println("Valor Flotante = " + valorFlotante);
        System.out.println("Valor Double = " + valorDouble);

        
        
        System.out.println("Tipo\tMinimo\tMaximo");
        System.out.println("byte\t"+ Byte.MIN_VALUE + "\t" +Byte.MAX_VALUE);
        System.out.println("short\t"+ Short.MIN_VALUE + "\t" +Short.MAX_VALUE);
        System.out.println("int\t"+ Integer.MIN_VALUE + "\t" +Integer.MAX_VALUE);
        System.out.println("long\t"+ Long.MIN_VALUE + "\t" +Long.MAX_VALUE);
        System.out.println("float\t"+ Float.MIN_VALUE + "\t" +Float.MAX_VALUE);
        System.out.println("double\t"+ Double.MIN_VALUE + "\t" +Double.MAX_VALUE);
        
        
        
    }

    public static void mostrarInformacion() {
        //Tipos de datos enteros ejemplo de Maximo y minimo valor

        //un byte utiliza 8 bits de memoria
        byte miByteValorMin = -128;
        byte miByteValorMax = 127;

        //un shor utiliza 16 bits de memoria
        short miShortValorMin = -32768;
        short miShortValorMax = -32767;

        //un int utiliza 32 bits de memoria
        int miIntValorMin = -2147483648;
        int miIntValorMax = 2147483647;

        //un long utiliza 64 bits de memoria
        long miLongValorMin = -9223372036854775808L;
        long miLongValorMax = 9223372036854775807L;

        System.out.println("Valor minimo de un byte:" + miByteValorMin + " Valor Maximo=" + miByteValorMax + " y utiliza 8 bits de memoria");
        System.out.println("Valor minimo de un short:" + miShortValorMin + " Valor Maximo=" + miShortValorMax + " y utiliza 16 bits de memoria");
        System.out.println("Valor minimo de un int:" + miIntValorMin + " Valor Maximo=" + miIntValorMax + " y utiliza 32 bits de memoria");
        System.out.println("Valor minimo de un long:" + miLongValorMin + " Valor Maximo=" + miLongValorMax + " y utiliza 64 bits de memoria");

    }

}
