/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.view;

import com.icaballero.negocio.CatalagoPeliculas;
import com.icaballero.negocio.CatalagoPeliculasImpl;
import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final CatalagoPeliculas catalogoPeli = new CatalagoPeliculasImpl();
    private static final String NOMBRE_ARCHIVO = "..//CatalagoPeliculas.txt";

    public static void main(String[] args) {

        showMenu();

    }

    private static void showMenu() {
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Buscar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogoPeli.iniciarArchivo(NOMBRE_ARCHIVO);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de una pelicula a agregar:");
                        String nombre = scanner.nextLine();
                        catalogoPeli.agregarPelicula(nombre, NOMBRE_ARCHIVO);
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogoPeli.listarPeliculas(NOMBRE_ARCHIVO);
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoPeli.buscarPelicula(NOMBRE_ARCHIVO, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
}
