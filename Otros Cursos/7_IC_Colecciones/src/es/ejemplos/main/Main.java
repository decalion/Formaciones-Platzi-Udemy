package es.ejemplos.main;

import es.ejemplos.beans.Coche;
import es.ejemplos.beans.ManejadorColecciones;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManejadorColecciones<Coche> colecciones = applicationContext.getBean("colecciones", ManejadorColecciones.class);

        colecciones.mostrarLista();
        colecciones.mostrarArray();
        colecciones.mostrarConjunto();
        colecciones.mostrarMapa();
        colecciones.mostrarPropiedades();
    }

}
