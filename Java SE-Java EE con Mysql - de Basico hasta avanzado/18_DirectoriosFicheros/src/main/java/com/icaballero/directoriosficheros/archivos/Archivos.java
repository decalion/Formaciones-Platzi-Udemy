/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.directoriosficheros.archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;

/**
 *
 * @author ismael
 */
public class Archivos {

    //Crear directorio
    public static void crearDirectorio(String directorio) throws IOException {

        Path dirPath = Paths.get(directorio);

        //Si no existe creamos el directorio
        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }
    }

    //Crear arrchivo
    public static void crearArchivo(String rutaArchivo) throws IOException {
        Path dirPath = Paths.get(rutaArchivo);

        if (Files.notExists(dirPath)) {
            Files.createFile(dirPath);
        }

    }

    //Informacion de un archivo
    public static void informacionArchivo(String rutaArchivo) throws IOException {
        Path dirPath = Paths.get(rutaArchivo);

        System.out.println("Nombre archivo : " + dirPath.getFileName());
        System.out.println("Ruta Absoluta : " + dirPath.toAbsolutePath());
        System.out.println("El archivo se puede escribir ? : " + Files.isWritable(dirPath));
        System.out.println("Tamaño del archivo : " + Files.size(dirPath));

    }

    //Mostrar los archivos de un directorio
    public static void mostrarArchivosDirectorio(String directorio) throws IOException {
        Path dirPath = Paths.get(directorio);

        //Si existe el directorio y si es un directorio
        if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {

            System.out.println("Directorio : " + dirPath.toAbsolutePath());
            System.out.println("Archivos : ");

            DirectoryStream<Path> direStream = Files.newDirectoryStream(dirPath);

            for (Path path : direStream) {

                if (Files.isRegularFile(path)) {
                    System.out.println("      " + path.getFileName());
                }

            }

        }

    }

    //Eliminar un archivo o directorio
    public static void eliminarArchivoDirectorio(String ruta) throws IOException {
        Path dirPath = Paths.get(ruta);

        if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
            Files.delete(dirPath);

        } else {
            Path filePath = Paths.get(ruta);
            if (Files.exists(filePath) && Files.isRegularFile(filePath)) {

                Files.delete(filePath);
            }
        }

    }

    //Copiar un archivo de un origin a un destino
    public static void copiarArchivo(String origen, String destino) throws IOException {
        Path filePathO = Paths.get(origen);
        Path filePathD = Paths.get(destino);

        Files.copy(filePathO, filePathD);

    }

    //Mover un archivo de un origin a un destino
    public static void moverArchivo(String origen, String destino) throws IOException {
        Path filePathO = Paths.get(origen);
        Path filePathD = Paths.get(destino);

        Files.move(filePathO, filePathD);

    }

    public static void escribir(String linea) {

        Path path = Paths.get("./src/prueba/test.txt");
        File file = path.toFile();

        try ( PrintWriter outputSream = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file, true)))) {

            outputSream.println(linea);

        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void leer() {

        Path path = Paths.get("./src/prueba/test.txt");
        File file = path.toFile();

        if (Files.exists(path)) {

            try ( BufferedReader inputStream = new BufferedReader(
                    new FileReader(file))) {

                String linea = inputStream.readLine();

                while (linea != null) {
                    System.out.println(linea);
                    linea=inputStream.readLine();
                }

            } catch (IOException e) {

            }

        }

    }

}
