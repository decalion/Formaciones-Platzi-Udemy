/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodatetime;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author ismael
 */
public class ComparaDateTime {

    public static void main(String[] args) {

        ComparaDateTime obj = new ComparaDateTime();
        obj.isBefore();
        obj.isAfter();
        obj.compareTo();

    }

    public void isBefore() {
        LocalDate fecha1 = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(2018, Month.OCTOBER, 31);

        if (fecha1.isBefore(fecha2)) {

            System.out.println("El dia " + fecha1 + " SI esta antes de " + fecha2);

        } else {
            System.out.println("El dia " + fecha1 + " NO esta antes de " + fecha2);
        }

    }

    public void isAfter() {

        LocalDate fecha1 = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(2018, Month.OCTOBER, 31);

        if (fecha1.isAfter(fecha2)) {

            System.out.println("El dia " + fecha1 + " SI esta despues de " + fecha2);

        } else {
            System.out.println("El dia " + fecha1 + " NO esta despues de " + fecha2);
        }

    }

    public void compareTo() {
        LocalDate fecha1 = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(2019, Month.AUGUST, 30);

        if (fecha1.compareTo(fecha2) < 0) {

            System.out.println("La fecha " + fecha1 + " esta ANTES  de la fecha " + fecha2);
        } else if (fecha1.compareTo(fecha2) > 0) {
            System.out.println("La fecha " + fecha1 + " esta DESPUESde la fecha " + fecha2);
        } else {
            System.out.println("La fecha " + fecha1 + " esta IGUAL a la fecha " + fecha2);
        }

        fecha1.compareTo(fecha2);

    }

}
