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
    	//Ejemplo 3: Usando ApplicationContext, el contenedor invocar� al constructor de la clase, que recibir� unos par�metros,
    	//cada uno de los cuales representa una dependencia.
        ApplicationContext bean = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Servicio servicio = bean.getBean("servicio", Servicio.class);
        
        System.out.println("El valor es " + servicio.hacerOperacion());

    }

}