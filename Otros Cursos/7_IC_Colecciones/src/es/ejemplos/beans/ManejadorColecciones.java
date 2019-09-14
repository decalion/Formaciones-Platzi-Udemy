package es.ejemplos.beans;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class ManejadorColecciones<E>{
	
    private List<E> lista;
    private E[] arrayElementos;
    private Set<E> conjunto;
    private Map<String, E> mapa;
    private Properties propiedades;

    
    public void setArrayElementos(E[] arrayElementos)
    {
        this.arrayElementos = arrayElementos;
    }

    public void setConjunto(Set<E> conjunto)
    {
        this.conjunto = conjunto;
    }

    public void setLista(List<E> lista)
    {
        this.lista = lista;
    }

    public void setMapa(Map<String, E> mapa)
    {
        this.mapa = mapa;
    }

    public void setPropiedades(Properties propiedades)
    {
        this.propiedades = propiedades;
    }

    
    public void mostrarLista()
    {
        System.out.println("\nEJEMPLO LIST: ");
        System.out.println("----------------------------------------------------------------------------");

        for (E e : lista)
        {
            System.out.println(e);
        }
    }

    public void mostrarArray()
    {
        System.out.println("\nEJEMPLO ARRAYS: ");
        System.out.println("----------------------------------------------------------------------------");

        for (E e : arrayElementos)
        {
            System.out.println(e);
        }
    }

    public void mostrarConjunto()
    {
        System.out.println("\nEJEMPLO SET: ");
        System.out.println("----------------------------------------------------------------------------");

        for (Iterator<E> it = conjunto.iterator(); it.hasNext();)
        {
            E e = it.next();

            System.out.println(e);
        }
    }

    public void mostrarMapa()
    {
        System.out.println("\nEJEMPLO MAP: ");
        System.out.println("----------------------------------------------------------------------------");

       
        for (Iterator<String> it = mapa.keySet().iterator(); it.hasNext();)
        {
            String e = it.next();

            System.out.println("[clave]"+ e + ", [valor]:" + mapa.get(e) );
        }
    }

    public void mostrarPropiedades()
    {
        System.out.println("\nEJEMPLO PROPIEDADES: ");
        System.out.println("----------------------------------------------------------------------------");

        for (Iterator it = propiedades.keySet().iterator(); it.hasNext();)
        {
            Object o = it.next();

            System.out.println("[clave]: " + o + ", [valor]: " + propiedades.get(o) );
        }
    }
}
