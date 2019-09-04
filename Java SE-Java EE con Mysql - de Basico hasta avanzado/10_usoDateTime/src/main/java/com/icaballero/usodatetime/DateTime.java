/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 *
 * @author ismael
 */
public class DateTime {

    public static void main(String[] args) {

        DateTime obj = new DateTime();
        obj.usarNow();
        System.out.println("------------------------");
        obj.usarOf();
        System.out.println("------------------------");
        obj.usarParse();
        System.out.println("------------------------");
        obj.regresarDateTime();

    }

    public void regresarDateTime() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("La fecha y hora actual es : " + fechaHoraActual);
        System.out.println(" Año : " + fechaHoraActual.getYear());
        System.out.println(" Mes : " + fechaHoraActual.getMonth());
        System.out.println(" Mes en numero : " + fechaHoraActual.getMonthValue());
        System.out.println(" dia del mes : " + fechaHoraActual.getDayOfMonth());
        System.out.println(" dia del año : " + fechaHoraActual.getDayOfYear());
        System.out.println(" dia en nombre : " + fechaHoraActual.getDayOfWeek());
        System.out.println(" Hora : " + fechaHoraActual.getHour());
        System.out.println(" Minutos : " + fechaHoraActual.getMinute());
        System.out.println("Segundos : " + fechaHoraActual.getSecond());
        System.out.println("NanoSegundos : " + fechaHoraActual.getNano());

        Month mes = fechaHoraActual.getMonth();
        System.out.println(mes);
        DayOfWeek dia = fechaHoraActual.getDayOfWeek();
        System.out.println(dia);

    }

    public void usarParse() {
        LocalDate fecha = LocalDate.parse("2019-09-30");
        System.out.println("LocalDate.parse : " + fecha);

        LocalTime tiempo1 = LocalTime.parse("16:37:45");
        System.out.println("LocalTime.parse : " + tiempo1);

        LocalDateTime fechaTiempo = LocalDateTime.parse("2019-09-30T17:37:45.123456789");
        System.out.println("LocalDateTime.parse : " + fechaTiempo);

    }

    public void usarOf() {
        LocalDate fecha1 = LocalDate.of(2019, Month.SEPTEMBER, 30);
        LocalDate fecha2 = LocalDate.of(2019, 9, 30);
        System.out.println("LocalDarte.of : " + fecha1);
        System.out.println("LocalDarte.of : " + fecha2);

        LocalTime tiempo1 = LocalTime.of(16, 59);
        LocalTime tiempo2 = LocalTime.of(16, 59, 59);
        LocalTime tiempo3 = LocalTime.of(16, 59, 59, 123456789);
        System.out.println("LocalTime.of : " + tiempo1);
        System.out.println("LocalTime.of : " + tiempo2);
        System.out.println("LocalTime.of : " + tiempo3);

        LocalDateTime fechaYHora = LocalDateTime.of(1981, 10, 16, 14, 32);
        System.out.println("LocalDateTime.of : " + fechaYHora);

    }

    public void usarNow() {

        LocalDate fechaActual = LocalDate.now();
        LocalTime tiempoActual = LocalTime.now();
        LocalDateTime fechaTiempoActual = LocalDateTime.now();

        System.out.println("LocalDate : " + fechaActual);
        System.out.println("LocalTime : " + tiempoActual);
        System.out.println("LocalDateTime : " + fechaTiempoActual);

    }

}
