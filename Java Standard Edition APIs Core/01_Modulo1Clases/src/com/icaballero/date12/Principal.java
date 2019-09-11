package com.icaballero.date12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo LocalDate Java8
		
		//Fecha Actual
		LocalDate miFecha = LocalDate.now();
		
		//Fecha predefinida
		LocalDate miFecha2 = LocalDate.of(2016,10,10);
		
		System.out.println(miFecha.getMonth());
		System.out.println(miFecha.getDayOfMonth());
		System.out.println(miFecha.getYear());
		
		//miFecha es antes que mifecha2
		System.out.println(miFecha.isBefore(miFecha2));
		
		System.out.println(miFecha2.isBefore(miFecha));
		
		//inmutabilidad (Se pueden modicar las fechas pero generando un nuevo objeto)
		LocalDate fecha3=miFecha2.withDayOfMonth(20);
		System.out.println(fecha3.getDayOfMonth());
		
		
		//Ejemplo de imutabilidad
		LocalDate fecha4 = LocalDate.of(2015, 1, 1);
		LocalDate fecha5=fecha4.plusYears(1);
		LocalDate fecha6=fecha5.plusMonths(1);
		System.out.println();
		System.out.println(fecha4);
		System.out.println(fecha5);
		System.out.println(fecha6);
		
		System.out.println(fecha4.plusYears(1).plusMonths(1));
		
		
		
		//Ejemplo de Period
		
		Period periodo = Period.between(miFecha, miFecha2);
		//Cuantos meses hay entre las 2 fechas
		System.out.println(periodo.getMonths());
		
		Period periodo1 = Period.between(miFecha2, miFecha);
		System.out.println(periodo1.getMonths());
		
		System.out.println(periodo1.getYears());
	}
	

}
