/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.tiposprimitivos;

/**
 *
 * @author ismael
 */
public class ConvertirBase {
    
    public static void main(String[] args) {
        
        int decimal = 10;
        System.out.println("Decimal :"+decimal);
        
        //para trabajar con octales hay que poner el 0 delante
        int octal =012;
        System.out.println("Octal: "+octal);
        
        //Para que sea hexadecimal hay poner el 0x delante
        int hexadecimal = 0xA;
        System.out.println("Hexadecimal : " +hexadecimal);
        
        //0b para numero binarios
        int binario = 0b1010;
        System.out.println("Binarios : "+binario);
        
        
        
    }
            
    
}
