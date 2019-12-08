/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.senteciasdecontrol;

import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class SentenciaIF {

    public static void main(String[] args) {

        var condicion = true;

        if (condicion) {

            System.out.println("Condicion verdadera");

        } else {
            System.out.println("Condicion falsa");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Proporciona un valor entre 0 y 10:");
        int calificacion = Integer.parseInt(scanner.nextLine());
        //Si esta entre 9 y 10 imprimir: A
        if (calificacion >= 9 && calificacion <= 10) {
            System.out.println("A");
        } //Si esta entre  8 y menor a 9 imprimir: B
        else if (calificacion >= 8 && calificacion < 9) {
            System.out.println("B");
        } //Si esta entre 7 y menor a 8 imprimir: C
        else if (calificacion >= 7 && calificacion < 8) {
            System.out.println("C");
        } //Si esta entre 6 y menor a 7 imprimir: D
        else if (calificacion >= 6 && calificacion < 7) {
            System.out.println("D");
        } //Si esta entre 0 y menor a 6 imprimir: F
        else if (calificacion >= 0 && calificacion < 6) {
            System.out.println("F");
        } //Si no esta en el rago, imprimir: Valor desconocido
        else {
            System.out.println("Valor desconocido");
        }
    }

}
