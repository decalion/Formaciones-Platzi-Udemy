/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodestring;

/**
 *
 * @author ismael
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        StringBasics str = new StringBasics();
        
        str.showStrings();
        
        System.out.println("\n\n");
        
        CompararStrings eq = new CompararStrings();
        eq.compararDtrings();
        
        
    }
    
}
