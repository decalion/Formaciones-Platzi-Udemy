package es.ejemplos.main;


import es.ejemplos.beans.Servicio;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;



public class Main
{


    public static void main(String[] args)
    {
        
    	//Ejemplo 1: Usando BeanFactory
    	//Para usar BeanFactory, se necesita las librerias de Spring Core, Context y el Commons-logging.
    	//BeanFactory bean = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        
    	
    	//Ejemplo 2: Usando ApplicationContext
    	//Para usar ApplicationContext, se ha de añadir las libreris Spring ASM y EXPRESSION.
        ApplicationContext bean = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        //Llamamos al método getBean para que nos devuelva el objeto que necesitamos. El primer parámetro es el alias del bean que 
        //queremos recuperar, y el segundo es para indicarle que tipo de objeto nos va a devolver, de esta manera no tenemos que 
        //hacer el casting.
        Servicio servicio = bean.getBean("servicio", Servicio.class);
        
        System.out.println("El valor es " + servicio.hacerOperacion());

    }

}