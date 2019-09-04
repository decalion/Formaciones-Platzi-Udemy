/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.usodatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ismael
 */
public class AjustDateTime {
    
    
    public static void main(String[] args) {
        
        AjustDateTime obj = new AjustDateTime();
        obj.ajustarDateTime();
        System.out.println("----------------------------");
        obj.modificarTiempo();
        
    }
    
    public void ajustarDateTime(){
        
        LocalDate fecha1 = LocalDate.of(2017, 10, 16);
        System.out.println("Fecha Actual " + fecha1);
        fecha1 = fecha1.withDayOfMonth(31);
        System.out.println("Fecha Cambiando el dia " + fecha1);
        fecha1 = fecha1.withMonth(2);
        System.out.println("Cambiando el mes : "+fecha1);
        fecha1 = fecha1.withDayOfYear(365);
        System.out.println("Cambiando el dia del año : "+fecha1);
        
        System.out.println("-------------------------");
        LocalTime horaActual =  LocalTime.now();
        System.out.println("La hora actual es : " + horaActual);
        horaActual= horaActual.withHour(10);
        System.out.println("Hora modificada es : "+horaActual);
        horaActual = horaActual.withMinute(59);
        System.out.println("El minuto modificado es " + horaActual);
        
        
    }
    
    
    public void modificarTiempo(){
        LocalDateTime fechaActual = LocalDateTime.now();
        System.out.println("Fecha y hora actual : "+fechaActual);
        fechaActual= fechaActual.plus(3, ChronoUnit.WEEKS);
        System.out.println("Sumamos 3 semanas a la fecha " + fechaActual);
        fechaActual= fechaActual.minus(3, ChronoUnit.WEEKS);
        System.out.println("Restamos 3 semanas a la fecha " + fechaActual);
    
         LocalDateTime fechaNueva = LocalDateTime.now();
         fechaNueva=fechaNueva.plusDays(15);
         System.out.println("Sumando 15 dias a la fecha "+fechaNueva);
    }
    
    
    
}
